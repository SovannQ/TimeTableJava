package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class SiteDAO extends DAO<Site> {
  public SiteDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(Site obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM site WHERE ID='"+obj.getId()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(Site obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO site(nom)" 
                      + "VALUES('" + obj.getNom()+"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean updateNom(Site obj, String nom) {   
      try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE site SET nom = '"+nom+"'"
                          + "WHERE ID = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
   
  @Override
  public Site find(int id) {
    Site site = new Site();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE ID = " + id);
      if(result.first())
        site = new Site(
          id,
          result.getString("nom")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return site;
  }

    @Override
    public boolean update(Site obj, int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}