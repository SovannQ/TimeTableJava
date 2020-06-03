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
public class GererPromotionControleur {
    
     private Promotion promotion;
     private ArrayList<typeCours> typecours = new ArrayList<typeCours>();
     private ArrayList<Groupe> groupe = new ArrayList<Groupe>();
     private ArrayList<Utilisateur> professeurs = new ArrayList<Utilisateur>();
     private ArrayList<Site> sites = new ArrayList<Site>();
     private ArrayList<Salle> salles = new ArrayList<Salle>();
     private ArrayList<Seance> seances = new ArrayList<Seance>();
     private ArrayList<Cours> cours = new ArrayList<Cours>();
     
     public GererPromotionControleur(int Id)
    {
        
        DAO<Professeur> professeurDao = new ProfesseurDAO(connection.getInstance());
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
        

        this.promotion = PromotionDao.find(Id);
        System.out.print("Promo : ");
        System.out.println(promotion.getNom());
        ArrayList<Groupe> groupes = GroupeDao.findAll(promotion.getId());
        for (Groupe j : groupes)
        {
            GererGroupeControleur essai = new GererGroupeControleur(j.getId());
            
            /*
            //Groupe
            System.out.print("Groupe : ");
           System.out.println(j.getNom());
           //On commence par définir une salle
           Salle salle = SalleDao.find(SeanceSalleDao.find(SeanceGroupeDao.find(j.getId()).getIdSeance()).getIdSalle());
           this.salles.add(salle);
           System.out.print("Salle : ");
           System.out.println(salle.getNom());
           //On defini la seance
           Seance seance = SeanceDao.find(SeanceGroupeDao.find(j.getId()).getIdSeance());
           this.seances.add(seance);
           System.out.print("Jour du cours : ");
           System.out.println(seance.getDate());
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
           System.out.println("-------------------------------------------");*/
         }
        
    }
}
