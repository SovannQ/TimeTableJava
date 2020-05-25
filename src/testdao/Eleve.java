package testdao;

public class Eleve {
  //ID
  private int id = 0;
  //Nom de l'élève
  private int numero = 0;
  //Prénom de l'élève
  private int IDgroupe = 0;
   
  public Eleve(int id, int numero, int IDgroupe) {
    this.id = id;
    this.numero = numero;
    this.IDgroupe = IDgroupe;
  }
  public Eleve(){};
     
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getNum() {
    return numero;
  }

  public void setNom(int num) {
    this.numero = num;
  }

  public int getGroupe() {
    return IDgroupe;
  }

  public void setGroupe(int groupe) {
    this.IDgroupe = groupe;
  }   
}