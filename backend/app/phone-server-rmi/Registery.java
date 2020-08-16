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
      MongoDatabase mongoDB = mongoClient.getDatabase("escola");

      // Exemplo professor
      ProfessorServerImpl professorServerImpl = new ProfessorServerImpl(mongoClient, mongoDB);
      Registry reg = LocateRegistry.createRegistry(3099);
      reg.bind("professor", professorServerImpl);
      System.out.println("Aguardando requisições...");
    } catch (RemoteException | AlreadyBoundException ex) {
      System.out.println(ex);
    }
  }
  
}
