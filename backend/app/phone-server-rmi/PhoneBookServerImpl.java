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
 * 
 * Classe responsável por prover uma implementação para cada um dos
 * métodos remotos presentes na interface PhoneBookServer.
 * Extende de UnicastRemoteObject
 * Implementa a interface PhoneBookServer.
 * 
 * @author João Paulo Back
 *
 */

class PhoneBookServerImpl extends UnicastRemoteObject implements PhoneBookServer{

  private ArrayList<PhoneBookEntry> contacts = new ArrayList<PhoneBookEntry>();
  private MongoClient connection;
  private MongoDatabase database;


  public PhoneBookServerImpl(MongoClient connection, MongoDatabase database) throws RemoteException{
    super();
    setConnection(connection);
    setDatabase(database);
  }
  
  public ArrayList<PhoneBookEntry> getPhoneBook(){
    return this.contacts;
  }

  public void addEntry(PhoneBookEntry entry){
    try{
      this.contacts.add(entry);
      Document document = new Document();
      document.put("firstname", entry.getFirstName());
      document.put("lastname", entry.getLastName());
      document.put("phone", entry.getPhoneNumber());
      this.database.getCollection("contacts").insertOne(document);
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