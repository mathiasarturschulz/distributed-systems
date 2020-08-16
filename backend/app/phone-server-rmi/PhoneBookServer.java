import java.rmi.*;
import java.util.ArrayList;

/**
 * 
 * Interface responsável por  declarar um conjunto de métodos
 * que poderão ser invocados por uma máquina virtual java remota.
 * Extende a interface Remote.
 * 
 * @author João Paulo Back
 *
 */

interface PhoneBookServer extends Remote{
  public ArrayList<PhoneBookEntry> getPhoneBook() throws RemoteException;
  public void addEntry(PhoneBookEntry entry) throws RemoteException;
}