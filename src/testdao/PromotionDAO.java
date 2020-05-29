package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class PromotionDAO extends DAO<Promotion> {
  public PromotionDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(Promotion obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM promotion WHERE ID='"+obj.getId()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(Promotion obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO promotion(Nom)" 
                      + "VALUES('" + obj.getNom()+"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean updateNom(Promotion obj, String nom) {   
      try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE promotion SET nom = '"+nom+"'"
                          + "WHERE ID = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
   
  @Override
  public Promotion find(int id) {
    Promotion promo = new Promotion();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM promotion WHERE ID = " + id);
      if(result.first())
        promo = new Promotion(
          id,
          result.getString("nom")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return promo;
  }

    @Override
    public boolean update(Promotion obj, int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}