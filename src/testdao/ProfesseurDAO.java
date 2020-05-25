/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

import java.sql.*;
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
    return false;
  }

  @Override
  public boolean delete(Professeur obj) {
    return false;
  }
   
  @Override
  public boolean update(Professeur obj) {
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

}