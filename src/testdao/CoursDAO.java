package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class CoursDAO extends DAO<Cours> {
  public CoursDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(Cours obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM cours WHERE ID='"+obj.getId()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(Cours obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO cours(Nom)" 
                      + "VALUES('" + obj.getNom()+"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean updateNom(Cours obj, String nom) {   
      try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE cours SET nom = '"+nom+"'"
                          + "WHERE ID = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
   
  @Override
  public Cours find(int id) {
    Cours cours = new Cours();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE ID = " + id);
      if(result.first())
        cours = new Cours(
          id,
          result.getString("nom")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return cours;
  }

    @Override
    public boolean update(Cours obj, int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}