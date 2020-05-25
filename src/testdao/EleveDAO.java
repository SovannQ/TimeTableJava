package testdao;
import java.sql.*;
//CTRL + SHIFT + O pour générer les imports
public class EleveDAO extends DAO<Eleve> {
  public EleveDAO(Connection conn) {
    super(conn);
  }

  @Override
  public boolean create(Eleve obj) {
    return false;
  }

  @Override
  public boolean delete(Eleve obj) {
    return false;
  }
   
  @Override
  public boolean update(Eleve obj) {
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
}