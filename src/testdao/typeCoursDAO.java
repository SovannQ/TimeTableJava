package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
//CTRL + SHIFT + O pour générer les imports
public class typeCoursDAO extends DAO<typeCours> {
  public typeCoursDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(typeCours obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM typecours WHERE ID='"+obj.getId()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(typeCours obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO typecours(Nom)" 
                      + "VALUES('" + obj.getNom()+"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean updateNom(typeCours obj, String nom) {   
      try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE typecours SET nom = '"+nom+"'"
                          + "WHERE ID = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
   
  @Override
  public typeCours find(int id) {
    typeCours typecours = new typeCours();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM typecours WHERE ID = " + id);
      if(result.first())
        typecours = new typeCours(
          result.getInt("ID"),
          result.getString("nom")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return typecours;
  }


    @Override
    public boolean update(typeCours obj, int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList findAll(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}