package testdao;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
//CTRL + SHIFT + O pour générer les imports
public class EleveDAO extends DAO<Eleve> {
  public EleveDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean delete(Eleve obj) {
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
  public boolean create(Eleve obj) {
      try {
      int result = this.connect.createStatement().executeUpdate(
              "INSERT INTO etudiant(IDutilisateur,numero,IDgroupe)" 
                      + "VALUES('" + obj.getId()+"','" + obj.getNum()+"','"+ obj.getGroupe() +"');");       
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return false;
  }
   
  @Override
  public boolean update(Eleve obj, int id) {   
      try {
          int result = this.connect.createStatement().executeUpdate(    
                  "UPDATE etudiant SET numero = '"+obj.getNum()+"'"
                          + "WHERE IDutilisateur ='"+id+"' ;");
      } catch (SQLException ex) {
          Logger.getLogger(EleveDAO.class.getName()).log(Level.SEVERE, null, ex);
      }
    return false;
  }
   
  @Override
  public Eleve find(int id) {
    Eleve eleve = new Eleve();      
      
    try {
      ResultSet result = this.connect.createStatement(
        ResultSet.TYPE_SCROLL_INSENSITIVE,
        ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM etudiant WHERE IDutilisateur = " + id);
      if(result.first())
        eleve = new Eleve(
          id,
          result.getInt("numero"),
          result.getInt("IDgroupe")
        );         
    } catch (SQLException e) {
        System.out.println(e);
            System.exit(1);
    }
    return eleve;
  }

    @Override
    public boolean updateNom(Eleve obj, String nom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}