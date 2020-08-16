import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Registery {

  public static void main(String[] args) throws RemoteException, MalformedURLException {
    try{
      MongoClient mongoClient = new MongoClient("localhost", 30001);
      MongoDatabase mongoDB = mongoClient.getDatabase("mongoContacts");  
      PhoneBookServerImpl phoneBookServerImpl = new PhoneBookServerImpl(mongoClient, mongoDB);
      Registry reg = LocateRegistry.createRegistry(3099);
      reg.bind("phonebook", phoneBookServerImpl);
      System.out.println("Aguardando requisições...");
    } catch (RemoteException | AlreadyBoundException ex) {
      System.out.println(ex);
    }
  }
  
}