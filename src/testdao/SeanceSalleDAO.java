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
public class SeanceSalleDAO extends DAO<SeanceSalle>{
    public SeanceSalleDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(SeanceSalle obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO seance_salles(IDseance,IDsalle)" 
                      + "VALUES('" + obj.getIdSeance()+"','" + obj.getIdSalle()+"');");
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }

  @Override
  public boolean delete(SeanceSalle obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM seance_salles WHERE IDseance='"+obj.getIdSeance()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
   
  @Override
  public boolean update(SeanceSalle obj, int num) {
       try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE seance-salles SET IDsalle = '"+num+"'"
                          + "WHERE IDseance = '"+obj.getIdSeance()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
  
  
    @Override
  public SeanceSalle find(int id) {
      SeanceSalle seanceSalle = new SeanceSalle();
      try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM enseignant WHERE IDutilisateur = " + id);
      if(result.first())
        seanceSalle = new SeanceSalle(
                result.getInt("IDseance"),
                result.getInt("IDsalle"));         
            } 
      catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
        }
        return seanceSalle;
    }
  
    @Override
    public boolean updateNom(SeanceSalle obj, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}