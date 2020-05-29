package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class GroupeDAO extends DAO<Groupe> {
  public GroupeDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(Groupe obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM groupe WHERE ID='"+obj.getId()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(Groupe obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO groupe(nom, IDpromo)" 
                      + "VALUES('" + obj.getNom()+"','" + obj.getIdPromotion()+"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean update(Groupe obj, int num) {   
      try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE groupe SET promo = '"+num+"',promo = '"+num+"'"
                          + "WHERE ID = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
   
  @Override
  public Groupe find(int id) {
    Groupe groupe = new Groupe();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM etudiant WHERE IDutilisateur = " + id);
      if(result.first())
        groupe = new Groupe(
          id,
          result.getString("nom"),
          result.getInt("IDpromo")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return groupe;
  }

    @Override
    public boolean updateNom(Groupe obj, String nom) {
        try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE groupe SET nom = '"+nom+"'"
                          + "WHERE ID = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
    }

}