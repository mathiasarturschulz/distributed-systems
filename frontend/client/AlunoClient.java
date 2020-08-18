import java.rmi.Naming;
import java.util.ArrayList;
import org.bson.Document;

class AlunoClient {
  public static void main(String[] args) throws Exception{
    AlunoServer alunoServer = (AlunoServer) Naming.lookup("rmi://localhost:3099/aluno");

    // Teste de cadastro de um aluno
    AlunoEntry alunoEntry = new AlunoEntry();
    alunoEntry.setNome("Mathias Schulz 2");
    alunoEntry.setMatricula("123456789-00");
    alunoServer.insertOne(alunoEntry);
    System.out.println("Teste de cadastro de um aluno! ");

    // // Teste de alteração de um aluno
    // AlunoEntry alunoEntry2 = new AlunoEntry();
    // alunoEntry2.setNome("Mathias Schulz ATUALIZADO");
    // alunoServer.updateOne("5f39c30f1e7c506fab7fd657", alunoEntry2);
    // System.out.println("Teste de alteração de um aluno! ");

    // // Teste de busca de um aluno
    // System.out.println(alunoServer.findOne("id"));
    // System.out.println("Teste de busca de um aluno! ");

    // Teste de busca de todos os alunoes
    ArrayList<Document> docs = alunoServer.find();
    int n = docs.size();
    for (int i=0; i<n; i++) {
      System.out.println(docs.get(i));
    }
    System.out.println("Teste de busca de todos os alunoes! ");

    // // Teste de exclusão de um aluno
    // alunoServer.deleteOne("id");
    // System.out.println("Teste de exclusão de um aluno! ");
  }
}
