import java.io.Serializable;

/**
 * Classe responsável por representar o tipo de dado ProfessorEntry.
 * Implementa a interface Serializable.
 * 
 * @author Mathias Artur Schulz
 */
public class AlunoEntry implements Serializable {

  private static final long serialVersionUID = 1L;

  private String ID;
  private String nome;
  private String matricula;

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
  public String getMatricula() {
    return this.matricula;
  }
  public void setMatricula(String matricula) {
    this.matricula = matricula;
  }

  @Override
  public String toString() {
    return getID() + " - " + getNome() + " - " + getMatricula();
  }
}
