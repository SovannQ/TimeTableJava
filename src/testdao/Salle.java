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
public class Salle {
    private int Id;
    private String nom;
    private int capacite;
    private int IdSite;

    public int getId() {
        return Id;
    }

    public String getNom() {
        return nom;
    }

    public int getCapacite() {
        return capacite;
    }

    public int getIdSite() {
        return IdSite;
    }

    public Salle() {
    }

    public Salle(int Id, String nom, int capacite, int IdSite) {
        this.Id = Id;
        this.nom = nom;
        this.capacite = capacite;
        this.IdSite = IdSite;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    public void setIdSite(int IdSite) {
        this.IdSite = IdSite;
    }
    
}
