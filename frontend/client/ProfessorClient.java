import java.rmi.Naming;

class ProfessorClient{
  public static void main(String[] args) throws Exception{
    ProfessorServer professorServer = (ProfessorServer) Naming.lookup("rmi://localhost:3099/professor");
    ProfessorEntry professorEntry = new ProfessorEntry();
    professorEntry.setNome("joao");
    professorEntry.setTitulacao("back");
    professorEntry.setEmail("991315568");
    professorServer.insertOne(professorEntry);
    professorServer.find().forEach(System.out::println);
  }
}