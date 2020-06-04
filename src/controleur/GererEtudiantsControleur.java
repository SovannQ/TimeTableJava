/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;
import testdao.*;
import java.util.*;


/**
 *
 * @author sovannquaglieri
 */
public class GererEtudiantsControleur {
    
     private Eleve eleve;
     private ArrayList<typeCours> typecours = new ArrayList<typeCours>();
     private Utilisateur utilisateur;
     private Groupe groupe;
     private ArrayList<Utilisateur> professeurs = new ArrayList<Utilisateur>();
     private ArrayList<Site> sites = new ArrayList<Site>();
     private ArrayList<Salle> salles = new ArrayList<Salle>();
     private ArrayList<Seance> seances = new ArrayList<Seance>();
     private ArrayList<Cours> cours = new ArrayList<Cours>();
     
     
     
    public GererEtudiantsControleur(int Id)
    {
        DAO<Eleve> eleveDao = new EleveDAO(connection.getInstance());
        DAO<Utilisateur> UtilisateurDao = new UtilisateurDAO(connection.getInstance());
        DAO<Cours> CoursDao = new CoursDAO(connection.getInstance());
        DAO<typeCours> typeCoursDao = new typeCoursDAO(connection.getInstance());
        DAO<Groupe> GroupeDao = new GroupeDAO(connection.getInstance());
        DAO<Site> SiteDao = new SiteDAO(connection.getInstance());
        DAO<Salle> SalleDao = new SalleDAO(connection.getInstance());
        DAO<Seance> SeanceDao = new SeanceDAO(connection.getInstance());
        DAO<SeanceGroupe> SeanceGroupeDao = new SeanceGroupeDAO(connection.getInstance());
        DAO<SeanceSalle> SeanceSalleDao = new SeanceSalleDAO(connection.getInstance());
        DAO<seanceEnseignant> SeanceEnseignantDao = new seanceEnseignantDAO(connection.getInstance());
        
        
        this.utilisateur = UtilisateurDao.find(Id);
        this.eleve =  eleveDao.find(Id);
        this.groupe = GroupeDao.find(eleve.getGroupe());
        System.out.print("Elève numéro: ");
        System.out.println(eleve.getNum());
        ArrayList<SeanceGroupe> seancesgroupes = SeanceGroupeDao.findAll(eleve.getGroupe());
        for (SeanceGroupe j : seancesgroupes)
        {
           //On defini la seance
           Seance seance = SeanceDao.find(j.getIdSeance());
           this.seances.add(seance);
        }
        for (Seance j : seances)
        {
           Seance seance = j;
           System.out.print("Jour du cours : ");
           System.out.println(seance.getDate().toString());
           System.out.print("Horaires du cours : ");
           System.out.print(seance.getHeureDebut());
           System.out.print("-");
           System.out.println(seance.getHeureFin());
           //On commence par définir une salle
           Salle salle = SalleDao.find(SeanceSalleDao.find(seance.getId()).getIdSalle());
           this.salles.add(salle);
           System.out.print("Salle : ");
           System.out.println(salle.getNom());
           //le cours
           Cours cours = CoursDao.find(seance.getIdCours());
           this.cours.add(cours);
           System.out.print("Nom du cours: ");
           System.out.println(cours.getNom());
           //type du cours
           typeCours typecours = typeCoursDao.find(seance.getIdType());
           this.typecours.add(typecours);
           System.out.print("Type de cours : ");
           System.out.println(typecours.getNom());
           //Le site des cours
           System.out.print("Site du cours : ");
           Site site = SiteDao.find(salle.getIdSite());
           this.sites.add(site);
           System.out.println(site.getNom());
           //Professeurs
           System.out.print("Professeur : ");
           Utilisateur prof = UtilisateurDao.find(SeanceEnseignantDao.find(seance.getId()).getIdEnseignant());
           this.professeurs.add(prof);
           System.out.println(prof.getNom());
           System.out.println("-------------------------------------------");
        }  
    }
    
    public GererEtudiantsControleur(int Id, int semaine)
    {
        
        DAO<Eleve> eleveDao = new EleveDAO(connection.getInstance());
        DAO<Utilisateur> UtilisateurDao = new UtilisateurDAO(connection.getInstance());
        DAO<Cours> CoursDao = new CoursDAO(connection.getInstance());
        DAO<typeCours> typeCoursDao = new typeCoursDAO(connection.getInstance());
        DAO<Promotion> PromotionDao = new PromotionDAO(connection.getInstance());
        DAO<Groupe> GroupeDao = new GroupeDAO(connection.getInstance());
        DAO<Site> SiteDao = new SiteDAO(connection.getInstance());
        DAO<Salle> SalleDao = new SalleDAO(connection.getInstance());
        DAO<Seance> SeanceDao = new SeanceDAO(connection.getInstance());
        DAO<SeanceGroupe> SeanceGroupeDao = new SeanceGroupeDAO(connection.getInstance());
        DAO<SeanceSalle> SeanceSalleDao = new SeanceSalleDAO(connection.getInstance());
        DAO<seanceEnseignant> SeanceEnseignantDao = new seanceEnseignantDAO(connection.getInstance());
        
        
        this.utilisateur = UtilisateurDao.find(Id);
        this.eleve =  eleveDao.find(Id);
        this.groupe = GroupeDao.find(eleve.getGroupe());
        System.out.print("Elève numéro: ");
        System.out.println(eleve.getNum());
        ArrayList<SeanceGroupe> seancesgroupes = SeanceGroupeDao.findAll(eleve.getGroupe());
        for (SeanceGroupe j : seancesgroupes)
        {
            if(SeanceDao.find(j.getIdSeance()).getSemaine() == semaine)
            {
                //On defini la seance
                Seance seance = SeanceDao.find(j.getIdSeance());
                this.seances.add(seance); 
            }
            
        }
        for (Seance j : seances)
        {
           Seance seance = j;
           System.out.print("Jour du cours : ");
           System.out.println(seance.getDate().toString());
           System.out.print("Horaires du cours : ");
           System.out.print(seance.getHeureDebut());
           System.out.print("-");
           System.out.println(seance.getHeureFin());
           //On commence par définir une salle
           Salle salle = SalleDao.find(SeanceSalleDao.find(seance.getId()).getIdSalle());
           this.salles.add(salle);
           System.out.print("Salle : ");
           System.out.println(salle.getNom());
           //le cours
           Cours cours = CoursDao.find(seance.getIdCours());
           this.cours.add(cours);
           System.out.print("Nom du cours: ");
           System.out.println(cours.getNom());
           //type du cours
           typeCours typecours = typeCoursDao.find(seance.getIdType());
           this.typecours.add(typecours);
           System.out.print("Type de cours : ");
           System.out.println(typecours.getNom());
           //Le site des cours
           System.out.print("Site du cours : ");
           Site site = SiteDao.find(salle.getIdSite());
           this.sites.add(site);
           System.out.println(site.getNom());
           //Professeurs
           System.out.print("Professeur : ");
           Utilisateur prof = UtilisateurDao.find(SeanceEnseignantDao.find(seance.getId()).getIdEnseignant());
           this.professeurs.add(prof);
           System.out.println(prof.getNom());
           System.out.println("-------------------------------------------");
        }
        
    }

    public Eleve getEleve() {
        return eleve;
    }

    public ArrayList<typeCours> getType_cours() {
        return typecours;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public ArrayList<Utilisateur> getProfesseurs() {
        return professeurs;
    }

    public ArrayList<Site> getSites() {
        return sites;
    }

    public ArrayList<Salle> getSalles() {
        return salles;
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public ArrayList<Cours> getCours() {
        return cours;
    }
    
    public ArrayList<Seance> TrierParHeure(ArrayList<Seance> Se){
        ArrayList<Seance> S = Se;
        Collections.sort(S, (Seance seance1, Seance seance2) -> seance1.getHeureDebut().compareTo(seance2.getHeureDebut()));
        for (Seance j : S)
        {
            System.out.println(j.getHeureDebut());
        }
        return S;
    }
}
