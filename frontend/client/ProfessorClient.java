import java.rmi.Naming;
import java.util.ArrayList;
import org.bson.Document;

class ProfessorClient {
  public static void main(String[] args) throws Exception{
    ProfessorServer professorServer = (ProfessorServer) Naming.lookup("rmi://localhost:3099/professor");

    // Teste de cadastro de um professor
    ProfessorEntry professorEntry = new ProfessorEntry();
    professorEntry.setNome("Paulo Silva");
    professorEntry.setTitulacao("Mestrando");
    professorEntry.setEmail("paulo@gmail.com");
    professorServer.insertOne(professorEntry);
    System.out.println("Teste de cadastro de um professor! ");

    // Teste de alteração de um professor
    ProfessorEntry professorEntry2 = new ProfessorEntry();
    professorEntry2.setNome("Gustavo Junior Jr.");
    professorServer.updateOne("5f39df226f6b1b1f9d8a39e7", professorEntry2);
    System.out.println("Teste de alteração de um professor! ");

    // Teste de busca de um professor
    System.out.println(professorServer.findOne("5f3b33aba9d75105c8cdc10c"));
    System.out.println("Teste de busca de um professor! ");

    // Teste de busca de todos os professores
    ArrayList<Document> docs = professorServer.find();
    int n = docs.size();
    for (int i=0; i<n; i++) {
      System.out.println(docs.get(i));
    }
    System.out.println("Teste de busca de todos os professores! ");

    // Teste de exclusão de um professor
    professorServer.deleteOne("5f3b33aba9d75105c8cdc10c");
    System.out.println("Teste de exclusão de um professor! ");
  }
}
