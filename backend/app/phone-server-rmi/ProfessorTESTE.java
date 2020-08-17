import java.rmi.Naming;

class ProfessorTESTE {
  public static void main(String[] args) throws Exception{
    ProfessorServer professorServer = (ProfessorServer) Naming.lookup("rmi://localhost:3099/professor");

    // // Teste de cadastro de um professor
    // ProfessorEntry professorEntry = new ProfessorEntry();
    // professorEntry.setNome("Mathias Schulz 2");
    // professorEntry.setTitulacao("Graduando 2");
    // professorEntry.setEmail("mathias@gmail.com 2");
    // professorServer.insertOne(professorEntry);
    // System.out.println("Teste de cadastro de um professor! ");

    // // Teste de alteração de um professor
    // ProfessorEntry professorEntry2 = new ProfessorEntry();
    // professorEntry2.setNome("Mathias Schulz ATUALIZADO");
    // professorServer.updateOne("5f39c30f1e7c506fab7fd657", professorEntry2);
    // System.out.println("Teste de alteração de um professor! ");

    // Teste de busca de um professor
    System.out.println(professorServer.findOne("5f39c30f1e7c506fab7fd657"));
    System.out.println("Teste de busca de um professor! ");
  }
}
