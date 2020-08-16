import java.rmi.Naming;

class ProfessorTESTE {
  public static void main(String[] args) throws Exception{
    ProfessorServer professorServer = (ProfessorServer) Naming.lookup("rmi://localhost:3099/professor");

    ProfessorEntry professorEntry = new ProfessorEntry();
    professorEntry.setNome("Mathias Schulz");
    professorEntry.setTitulacao("Graduando");
    professorEntry.setEmail("mathias@gmail.com");

    professorServer.insertOne(professorEntry);
    System.out.println("Sucesso! ");
  }
}
