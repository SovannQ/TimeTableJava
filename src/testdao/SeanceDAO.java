package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class SeanceDAO extends DAO<Seance> {
  public SeanceDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(Seance obj) {
            try {
      int result = this.connect.createStatement().executeUpdate(
              "DELETE FROM seance WHERE ID='"+obj.getId()+"';"); 
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
      return false;
  }
  

  @Override
  public boolean create(Seance obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO seance(semaine,date,heure_debut,heure_fin,etat,IDcours,IDtype)" 
                      + "VALUES('" + obj.getSemaine()+"','" + obj.getDate()+"','"+ obj.getHeureDebut() +"','"+ obj.getHeureFin() +"','"+ obj.getEtat() +"','"+ obj.getIdCours() +"','"+ obj.getIdType() +"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean update(Seance obj, int num) {   
      try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE etudiant SET numero = '"+num+"'"
                          + "WHERE IDutilisateur = '"+obj.getId()+"';"); 
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
   
  @Override
  public Seance find(int id) {
    Seance seance = new Seance();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM etudiant WHERE IDutilisateur = " + id);
      if(result.first())
        seance = new Seance(
          id,
          result.getInt("semaine"),
          result.getInt("date"),
          result.getInt("heure_debut"),
          result.getInt("heure_fin"),
          result.getInt("etat"),
          result.getInt("IDcours"),
          result.getInt("IDtype")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return seance;
  }

    @Override
    public boolean updateNom(Seance obj, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}