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

/**
 * Classe responsável por prover uma implementação para cada um dos
 * métodos remotos presentes na interface ProfessorServer.
 * Extende de UnicastRemoteObject
 * Implementa a interface ProfessorServer.
 * 
 * @author Mathias Artur Schulz
 */
class ProfessorServerImpl extends UnicastRemoteObject implements ProfessorServer {

  private ArrayList<ProfessorEntry> registers = new ArrayList<ProfessorEntry>();
  private MongoClient connection;
  private MongoDatabase database;

  public ProfessorServerImpl(MongoClient connection, MongoDatabase database) throws RemoteException {
    super();
    setConnection(connection);
    setDatabase(database);
  }

  public void insertOne(ProfessorEntry entry) {
    try {
      Document document = new Document();
      document.put("nome", entry.getNome());
      document.put("titulacao", entry.getTitulacao());
      document.put("email", entry.getEmail());
      this.database.getCollection("collectionProfessores").insertOne(document);
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }
  
  public void updateOne(String ID, ProfessorEntry entry) {
    try {
      Document document = new Document();
      if (entry.getNome() != null) {
        document.put("nome", entry.getNome());
      }
      if (entry.getTitulacao() != null) {
        document.put("titulacao", entry.getTitulacao());
      }
      if (entry.getEmail() != null) {
        document.put("email", entry.getEmail());
      }
      this.database.getCollection("collectionProfessores").updateOne(
        new Document("_id", new ObjectId(ID)), 
        new Document("$set", document)
      );
    }catch(Exception e){
      System.out.println(e.getMessage());
    }
  }

  public Document findOne(String ID) {
    try {
      return this.database.getCollection("collectionProfessores").find(
        new Document("_id", new ObjectId(ID))
      ).first();
    }catch(Exception e){
      System.out.println(e.getMessage());
      return null;
    }
  }

  // public Document find() throws RemoteException;
  // public Document deleteOne(String ID) throws RemoteException;

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
