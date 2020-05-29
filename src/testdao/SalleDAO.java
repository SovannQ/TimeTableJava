package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class SalleDAO extends DAO<Salle> {
  public SalleDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(Salle obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM salle WHERE ID='"+obj.getId()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(Salle obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO salle(nom,capacite,IDsite)" 
                      + "VALUES('" + obj.getNom()+"','" + obj.getCapacite()+"','" + obj.getIdSite()+"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean updateNom(Salle obj, String nom) {   
      try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE salle SET nom = '"+nom+"'"
                          + "WHERE ID = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
   
  @Override
  public Salle find(int id) {
    Salle salle = new Salle();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM salle WHERE ID = " + id);
      if(result.first())
        salle = new Salle(
          id,
          result.getString("nom"),
          result.getInt("capacite"),
          result.getInt("IDsite")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return salle;
  }

    @Override
    public boolean update(Salle obj, int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}