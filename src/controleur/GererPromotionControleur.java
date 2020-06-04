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
            essai.TrierParHeure(essai.getSeances());
        }
        
    }
     
     
     public GererPromotionControleur(int Id, int semaine)
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
            if(SeanceDao.find(SeanceGroupeDao.find(j.getId()).getIdSeance()).getSemaine() == semaine)
            {
                GererGroupeControleur essai = new GererGroupeControleur(j.getId(),semaine);
            }
         }
    }

    public Promotion getPromotion() {
        return promotion;
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

    public ArrayList<Salle> getSalles() {
        return salles;
    }

    public ArrayList<Seance> getSeances() {
        return seances;
    }

    public ArrayList<Cours> getCours() {
        return cours;
    }
}
