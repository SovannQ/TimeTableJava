package testdao;

public class Cours {
  //ID
  private int id = 0;
  //Nom du cours
  private String nom="";
   
  public Cours(int id, String nom) {
    this.id = id;
    this.nom = nom;
  }

  public Cours(){};
     
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return this.nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }


}