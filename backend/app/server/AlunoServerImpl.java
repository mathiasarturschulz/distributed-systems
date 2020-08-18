import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import static com.mongodb.client.model.Filters.eq;
import org.bson.types.ObjectId;
import org.w3c.dom.css.DocumentCSS;

/**
 * Classe responsável por prover uma implementação para cada um dos
 * métodos remotos presentes na interface AlunoServer.
 * Extende de UnicastRemoteObject
 * Implementa a interface AlunoServer.
 * 
 * @author Mathias Artur Schulz
 */
class AlunoServerImpl extends UnicastRemoteObject implements AlunoServer {

  private MongoClient connection;
  private MongoDatabase database;

  public AlunoServerImpl(MongoClient connection, MongoDatabase database) throws RemoteException {
    super();
    setConnection(connection);
    setDatabase(database);
  }

  public void insertOne(AlunoEntry entry) {
    try {
      Document document = new Document();
      document.put("nome", entry.getNome());
      document.put("matricula", entry.getMatricula());
      this.database.getCollection("collectionAlunos").insertOne(document);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  
  public void updateOne(String ID, AlunoEntry entry) {
    try {
      Document document = new Document();
      if (entry.getNome() != null) {
        document.put("nome", entry.getNome());
      }
      if (entry.getMatricula() != null) {
        document.put("matricula", entry.getMatricula());
      }
      this.database.getCollection("collectionAlunos").updateOne(
        new Document("_id", new ObjectId(ID)), 
        new Document("$set", document)
      );
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  public Document findOne(String ID) {
    try {
      return this.database.getCollection("collectionAlunos").find(
        new Document("_id", new ObjectId(ID))
      ).first();
    }catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }

  public ArrayList<Document> find() {
    try {
      ArrayList<Document> docs = new ArrayList<>();
      for (Document cur : this.database.getCollection("collectionAlunos").find()) {
        docs.add(cur);
      }
      return docs;
    }catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }
  
  public void deleteOne(String ID) {
    try {
      this.database.getCollection("collectionAlunos").deleteOne(
        new Document("_id", new ObjectId(ID))
      );
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  public MongoClient getConnection() { 
    return this.connection; 
  }

  public void setConnection(MongoClient connection) {
    this.connection = connection;
  }

  public MongoDatabase getDatabase() { 
    return this.database;  
  }

  public void setDatabase(MongoDatabase database) {
    this.database = database;
  }
}
