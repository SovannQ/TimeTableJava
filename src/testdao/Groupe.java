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
public class Groupe {
    private int Id;
    private String nom;
    private int IdPromotion;

    public Groupe(int Id, String nom, int IdPromotion) {
        this.Id = Id;
        this.nom = nom;
        this.IdPromotion = IdPromotion;
    }
    
    public Groupe(){
        
    }


    public int getId() {
        return Id;
    }

    public String getNom() {
        return nom;
    }

    public int getIdPromotion() {
        return IdPromotion;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setIdPromotion(int IdPromotion) {
        this.IdPromotion = IdPromotion;
    }
    
}
