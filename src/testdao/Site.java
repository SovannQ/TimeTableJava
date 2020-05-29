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
public class Site {
    private int Id;
    private String nom;

    public Site(int Id, String nom) {
        this.Id = Id;
        this.nom = nom;
    }

    public Site() {
    }

    public int getId() {
        return Id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
