import java.io.Serializable;

/**
 * 
 * Classe responsável por representar o tipo de dado PhoneBookEntry.
 * Implementa a interface Serializable.
 * 
 * @author João Paulo Back
 *
 */


class PhoneBookEntry implements Serializable{

  private String firstName;
  private String lastName;
  private String phoneNumber;

  public String getFirstName(){
    return this.firstName;
  }
  public void setFirstName(String firstName){
    this.firstName = firstName;
  }
  public String getLastName(){
    return this.lastName;
  }
  public void setLastName(String lastName){
    this.lastName = lastName;
  }
  public String getPhoneNumber(){
    return this.phoneNumber;
  }
  public void setPhoneNumber(String phoneNumber){
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString(){
    return getFirstName() + " - " + getLastName() + " - " + getPhoneNumber();
  }
}