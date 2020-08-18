import java.io.Serializable;

/**
 * Classe responsável por representar o tipo de dado DisciplinaEntry.
 * Implementa a interface Serializable.
 * 
 * @author Mathias Artur Schulz
 */
public class DisciplinaEntry implements Serializable {

  private static final long serialVersionUID = 1L;

  private String ID;
  private String nome;

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

  @Override
  public String toString() {
    return getID() + " - " + getNome();
  }
}
