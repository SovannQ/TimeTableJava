package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class seanceEnseignantDAO extends DAO<seanceEnseignant> {
  public seanceEnseignantDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(seanceEnseignant obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM seance_enseignant WHERE IDseance='"+obj.getIdSeance()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(seanceEnseignant obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO seance_enseignant(IDseance,IDenseignant)" 
                      + "VALUES('" + obj.getIdSeance()+"','" + obj.getIdEnseignant()+"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean updateNom(seanceEnseignant obj, String nom) {   
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
   
  @Override
  public seanceEnseignant find(int id) {
    seanceEnseignant seance_enseignant = new seanceEnseignant();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM cours WHERE ID = " + id);
      if(result.first())
        seance_enseignant = new seanceEnseignant(
          result.getInt("IDseance"),
          result.getInt("IDenseignant")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return seance_enseignant;
  }

    @Override
    public boolean update(seanceEnseignant obj, int num) {
        try {
                  int result = this.connect.createStatement().executeUpdate(    
                          "UPDATE seance_enseignant SET IDenseignant = '"+num+"'"
                                  + "WHERE IDseance = '"+obj.getIdSeance()+"';"); 
              } catch (SQLException ex) {
                  Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
              }
            return false;
            }
}