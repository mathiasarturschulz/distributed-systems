import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

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

  public Document insertOne(ProfessorEntry entry) {
    Document result = new Document();
    try {
      Document document = new Document();
      document.put("nome", entry.getNome());
      document.put("titulacao", entry.getTitulacao());
      document.put("email", entry.getEmail());
      this.database.getCollection("collectionProfessores").insertOne(document);
      result.put("result", "true");
    }catch(Exception e){
      System.out.println(e.getMessage());
      result.put("result", "false");
    }
    return result;
  }

  // public Document updateOne(PhoneBookEntry entry) throws RemoteException;
  // public Document findOne(String ID) throws RemoteException;
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
