import java.rmi.Naming;
import java.util.ArrayList;
import org.bson.Document;

class DisciplinaClient {
  public static void main(String[] args) throws Exception{
    DisciplinaServer disciplinaServer = (DisciplinaServer) Naming.lookup("rmi://localhost:3099/disciplina");

    // Teste de cadastro de uma disciplina
    DisciplinaEntry disciplinaEntry = new DisciplinaEntry();
    disciplinaEntry.setNome("POO II");
    disciplinaServer.insertOne(disciplinaEntry);
    System.out.println("Teste de cadastro de uma disciplina! ");

    // // Teste de alteração de uma disciplina
    // DisciplinaEntry disciplinaEntry2 = new DisciplinaEntry();
    // disciplinaEntry2.setNome("SISTEMAS DISTRIBUIDOS");
    // disciplinaServer.updateOne("5f39c30f1e7c506fab7fd657", disciplinaEntry2);
    // System.out.println("Teste de alteração de uma disciplina! ");

    // // Teste de busca de uma disciplina
    // System.out.println(disciplinaServer.findOne("ID"));
    // System.out.println("Teste de busca de uma disciplina! ");

    // Teste de busca de todos os disciplinas
    ArrayList<Document> docs = disciplinaServer.find();
    int n = docs.size();
    for (int i=0; i<n; i++) {
      System.out.println(docs.get(i));
    }
    System.out.println("Teste de busca de todos os disciplinas! ");

    // // Teste de exclusão de uma disciplina
    // disciplinaServer.deleteOne("id");
    // System.out.println("Teste de exclusão de uma disciplina! ");
  }
}
