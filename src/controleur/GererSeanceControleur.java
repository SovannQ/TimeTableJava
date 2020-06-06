/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import testdao.*;

/**
 *
 * @author titir
 */
public class GererSeanceControleur {
    
    public void ChangerNomCours(int Id, Seance seance)
    {
        DAO<Seance> SeanceDao = new SeanceDAO(connection.getInstance());
        Seance seance2 = SeanceDao.find(Id);
        seance2.setIdCours(seance.getIdCours());
    }
    
    public void ChangerTypeCours(int Id, Seance seance)
    {
        DAO<Seance> SeanceDao = new SeanceDAO(connection.getInstance());
        Seance seance2 = SeanceDao.find(Id);
        seance2.setIdType(seance.getIdType());
    }
    
    public void AnnulerSeance(int Id)
    {
        DAO<Seance> SeanceDao = new SeanceDAO(connection.getInstance());
        Seance seance2 = SeanceDao.find(Id);
        seance2.setEtat(0);
    }
    
    public void ValiderSeance(int Id)
    {
        DAO<Seance> SeanceDao = new SeanceDAO(connection.getInstance());
        Seance seance2 = SeanceDao.find(Id);
        seance2.setEtat(1);
    }
    
    public void EnleverGroupe(int IdSeance, int IdGroupe)
    {
        DAO<SeanceGroupe> SeanceGroupeDao = new SeanceGroupeDAO(connection.getInstance());
        SeanceGroupe SG = new SeanceGroupe(IdSeance,IdGroupe);
        SeanceGroupeDao.delete(SG);
    }
    
    public void EnleverEnseignant(int IdSeance, int IdProf)
    {
        DAO<seanceEnseignant> seanceEnseignantDao = new seanceEnseignantDAO(connection.getInstance());
        seanceEnseignant SE = new seanceEnseignant(IdSeance,IdProf);
        seanceEnseignantDao.delete(SE);
    }
}
