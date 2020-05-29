package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class UtilisateurDAO extends DAO<Utilisateur> {
  public UtilisateurDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(Utilisateur obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM etudiant WHERE IDutilisateur='"+obj.getId()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(Utilisateur obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO utilisateur(mail,password,nom,prenom,droit)" 
                      + "VALUES('" + obj.getMail()+"','" + obj.getPassword()+"','"+ obj.getNom() +"','" + obj.getPrenom()+"','" + obj.getDroit()+"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean update(Utilisateur obj, int num) {   
      try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE utilisateur SET numero = '"+num+"'"
                          + "WHERE IDutilisateur = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
   
  @Override
  public Utilisateur find(int id) {
    Utilisateur utilisateur = new Utilisateur();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM utilisateur WHERE IDutilisateur = " + id);
      if(result.first())
        utilisateur = new Utilisateur(
          id,
          result.getString("mail"),
          result.getString("password"),
          result.getString("nom"),
          result.getString("prenom"),
          result.getInt("droit")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return utilisateur;
  }

  @Override
    public boolean updateNom(Utilisateur obj, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
  
}