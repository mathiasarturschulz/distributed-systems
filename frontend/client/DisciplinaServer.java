import java.rmi.*;
import java.util.ArrayList;
import org.bson.Document;

/**
 * Interface responsável por declarar um conjunto de métodos
 * que poderão ser invocados por uma máquina virtual java remota.
 * Extende a interface Remote
 * 
 * @author Mathias Artur Schulz
 */
interface DisciplinaServer extends Remote {
  public void insertOne(DisciplinaEntry entry) throws RemoteException;
  public void updateOne(String ID, DisciplinaEntry entry) throws RemoteException;
  public Document findOne(String ID) throws RemoteException;
  public ArrayList<Document> find() throws RemoteException;
  public void deleteOne(String ID) throws RemoteException;
}
