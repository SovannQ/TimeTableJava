package testdao;

//CTRL + SHIFT + O pour générer les imports
public class TestDao{  
  public static void main(String[] args) {
    //Testons des élèves
    DAO<Eleve> eleveDao = new EleveDAO(connection.getInstance());
    DAO<Professeur> ProfesseurDao = new ProfesseurDAO(connection.getInstance());
    DAO<Utilisateur> UtilisateurDao = new UtilisateurDAO(connection.getInstance());
    DAO<Cours> CoursDao = new CoursDAO(connection.getInstance());
    DAO<typeCours> typeCoursDao = new typeCoursDAO(connection.getInstance());
    for(int i = 1; i < 6; i++){
      Eleve eleve = eleveDao.find(i);
      System.out.println("Elève N°" + eleve.getId() + "  - " + eleve.getNum() + " " + eleve.getGroupe());
    }
    Eleve eleve = new Eleve(5,63,1);
    Utilisateur user = new Utilisateur(1,"etienne@gmail.com","mdp","Rollin","Etienne",0);
    eleveDao.create(eleve);
    eleveDao.update(eleve,5);
    eleveDao.delete(eleve);
    UtilisateurDao.create(user);
    Cours cours = new Cours(1,"maths");
    CoursDao.updateNom(cours,"mathématiques");
    typeCours typecours = new typeCours(1,"td");
    typeCoursDao.updateNom(typecours,"tp");
    Professeur prof = ProfesseurDao.find(6);
    System.out.println("Professeur N°" + prof.getId() + "  - Matière - " + prof.getIdCours());
    System.out.println("\n********************************\n");

    }
}