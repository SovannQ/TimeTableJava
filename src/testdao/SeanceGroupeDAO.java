package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class SeanceGroupeDAO extends DAO<SeanceGroupe> {
  public SeanceGroupeDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(SeanceGroupe obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM seance_groupe WHERE IDseance='"+obj.getIdSeance()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(SeanceGroupe obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO seance_groupe(IDseance,IDgroupe)" 
                      + "VALUES('" + obj.getIdSeance()+"','" + obj.getIdGroupe()+"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean updateNom(SeanceGroupe obj, String nom) {   
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
   
  @Override
  public SeanceGroupe find(int id) {
    SeanceGroupe seance_groupe = new SeanceGroupe();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM seance_groupe WHERE ID = " + id);
      if(result.first())
        seance_groupe = new SeanceGroupe(
          result.getInt("IDseance"),
          result.getInt("IDGroupe")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return seance_groupe;
  }

    @Override
    public boolean update(SeanceGroupe obj, int num) {
        try {
                  int result = this.connect.createStatement().executeUpdate(    
                          "UPDATE seance_groupe SET IDgroupe = '"+num+"'"
                                  + "WHERE IDseance = '"+obj.getIdSeance()+"';"); 
              } catch (SQLException ex) {
                  Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
              }
            return false;
            }
}