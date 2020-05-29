package testdao;

public class seanceEnseignant {
  //ID
  private int idSeance = 0;
  //Nom du cours
  private int idEnseignant=0;
   
  public seanceEnseignant(int idSeance, int idEnseignant) {
    this.idSeance = idSeance;
    this.idEnseignant = idEnseignant;
  }

  public seanceEnseignant(){};
     
  public int getIdSeance() {
    return idSeance;
  }

  public void setIdSeance(int id) {
    this.idSeance = id;
  }

  public int getIdEnseignant() {
    return idEnseignant;
  }

  public void setIdEnseignant(int id) {
    this.idEnseignant = id;
  }
 


}