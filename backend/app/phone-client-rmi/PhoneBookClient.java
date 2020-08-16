import java.rmi.Naming;

class PhoneBookClient{
  public static void main(String[] args) throws Exception{
    PhoneBookServer phoneBookServer = (PhoneBookServer) Naming.lookup("rmi://localhost:3099/phonebook");

    PhoneBookEntry phoneBookEntry = new PhoneBookEntry();
    phoneBookEntry.setFirstName("joao");
    phoneBookEntry.setLastName("back");
    phoneBookEntry.setPhoneNumber("991315568");
    phoneBookServer.addEntry(phoneBookEntry);
    phoneBookServer.getPhoneBook().forEach(System.out::println);

  }
}