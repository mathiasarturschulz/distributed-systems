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
interface ProfessorServer extends Remote {
  public void insertOne(ProfessorEntry entry) throws RemoteException;
  public void updateOne(String ID, ProfessorEntry entry) throws RemoteException;
  public Document findOne(String ID) throws RemoteException;
  // public Document find() throws RemoteException;
  // public Document deleteOne(String ID) throws RemoteException;
}
