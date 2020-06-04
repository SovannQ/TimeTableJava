/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.util.ArrayList;
import testdao.*;

/**
 *
 * @author titir
 */
public class GererSalleControleur {
     private ArrayList<typeCours> typecours = new ArrayList<typeCours>();
     private ArrayList<Groupe> groupe = new ArrayList<Groupe>();
     private ArrayList<Utilisateur> professeurs = new ArrayList<Utilisateur>();
     private ArrayList<Site> sites = new ArrayList<Site>();
     private Salle salle;
     private ArrayList<Seance> seances = new ArrayList<Seance>();
     private ArrayList<Cours> cours = new ArrayList<Cours>();
     
     public GererSalleControleur(int Id)
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
        
        
        this.salle = SalleDao.find(Id);
        System.out.print("Salle numéro: ");
        System.out.println(salle.getNom());
        ArrayList<SeanceSalle> seancessalles = SeanceSalleDao.findAll(Id);
        for (SeanceSalle j : seancessalles)
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
     
     
     public GererSalleControleur(int Id, int semaine)
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
        
        
        this.salle = SalleDao.find(Id);
        System.out.print("Salle numéro: ");
        System.out.println(salle.getNom());
        ArrayList<SeanceSalle> seancessalles = SeanceSalleDao.findAll(Id);
        for (SeanceSalle j : seancessalles)
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

    public ArrayList<typeCours> getTypecours() {
        return typecours;
    }

    public ArrayList<Groupe> getGroupe() {
        return groupe;
    }

    public ArrayList<Utilisateur> getProfesseurs() {
        return professeurs;
    }

    public ArrayList<Site> getSites() {
        return sites;
    }

    public Salle getSalle() {
        return salle;
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public ArrayList<Cours> getCours() {
        return cours;
    }
}
