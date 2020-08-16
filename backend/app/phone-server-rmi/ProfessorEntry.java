import java.io.Serializable;

/**
 * Classe responsável por representar o tipo de dado ProfessorEntry.
 * Implementa a interface Serializable.
 * 
 * @author Mathias Artur Schulz
 */
public class ProfessorEntry implements Serializable {

  private static final long serialVersionUID = 1L;

  private String ID;
  private String nome;
  private String titulacao;
  private String email;

  public String getID() {
    return this.ID;
  }
  public void setID(String ID) {
    this.ID = ID;
  }
  public String getNome() {
    return this.nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getTitulacao() {
    return this.titulacao;
  }
  public void setTitulacao(String titulacao) {
    this.titulacao = titulacao;
  }
  public String getEmail() {
    return this.email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return getID() + " - " + getNome() + " - " + getTitulacao() + " - " + getEmail();
  }
}
