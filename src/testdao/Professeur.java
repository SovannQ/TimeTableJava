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
public class Professeur {
    private int id = 0;
    private int idCours = 0;
    
    public Professeur(int id, int idCours) {
    this.id = id;
    this.idCours = idCours;
  }
    
    public Professeur(){};
    
   public int getId()
   {
       return id;
   }
   public void setId(int id)
   {
       this.id = id;
   }
    
   public int getIdCours()
   {
       return idCours;
   }
   public void setIdCours(int id)
   {
       this.id = id;
   }
   
}
