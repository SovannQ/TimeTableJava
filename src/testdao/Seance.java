/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

/**
 *
 * @author titir
 */
public class Seance {
    private int Id;
    private int semaine;
    private int date;
    private int heureDebut;
    private int heureFin;
    private int etat;
    private int IdCours;
    private int IdType;

    public Seance(int Id, int semaine, int date, int heureDebut, int heureFin, int etat, int IdCours, int IdType) {
        this.Id = Id;
        this.semaine = semaine;
        this.date = date;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.etat = etat;
        this.IdCours = IdCours;
        this.IdType = IdType;
    }

    public Seance() {
    }

    public int getId() {
        return Id;
    }

    public int getSemaine() {
        return semaine;
    }

    public int getDate() {
        return date;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public int getEtat() {
        return etat;
    }

    public int getIdCours() {
        return IdCours;
    }

    public int getIdType() {
        return IdType;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public void setHeureFin(int heureFin) {
        this.heureFin = heureFin;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public void setIdCours(int IdCours) {
        this.IdCours = IdCours;
    }

    public void setIdType(int IdType) {
        this.IdType = IdType;
    }

    
    
}
