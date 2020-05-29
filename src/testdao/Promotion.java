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
public class Promotion {
    private int Id;
    private String Nom;

    public Promotion(int Id, String Nom) {
        this.Id = Id;
        this.Nom = Nom;
    }

    public Promotion() {
    }

    public int getId() {
        return Id;
    }

    public String getNom() {
        return Nom;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }
    
    
}
