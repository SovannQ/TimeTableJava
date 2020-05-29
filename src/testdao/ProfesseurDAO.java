/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author titir
 */
public class ProfesseurDAO extends DAO<Professeur>{
    public ProfesseurDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Professeur obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO enseignant(IDutilisateur,IDcours)" 
                      + "VALUES('" + obj.getId()+"','" + obj.getIdCours()+"');");
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }

  @Override
  public boolean delete(Professeur obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM enseignant WHERE IDutilisateur='"+obj.getId()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
   
  @Override
  public boolean update(Professeur obj, int num) {
       try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE enseignant SET IDcours = '"+num+"'"
                          + "WHERE IDutilisateur = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
  
  
    @Override
  public Professeur find(int id) {
      Professeur prof = new Professeur();
      try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignant WHERE IDutilisateur = " + id);
      if(result.first())
        prof = new Professeur(id,result.getInt("IDcours"));         
            } 
      catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
        }
        return prof;
    }
  
    @Override
    public boolean updateNom(Professeur obj, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}