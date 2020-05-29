/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;


import java.sql.*;

import javax.swing.JOptionPane;

public class connection{

  /**
  * URL de connection
  */
  private static String url = "jdbc:mysql://localhost:8889/planning?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";

  /**
  * Nom du user
  */
  private static String user = "root";

  /**
  * Mot de passe du user
  */
  private static String passwd = "root";

  /**
  * Objet Connection
  */
  private static Connection connect;

  /**
  * Méthode qui va retourner notre instance
  * et la créer si elle n'existe pas...
  * @return
  */
  public static Connection getInstance(){
    if(connect == null){
      try {
        connect = DriverManager.getConnection(url, user, passwd);
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "ERREUR DE CONNEXION ! ", JOptionPane.ERROR_MESSAGE);
      }
    }		
    return connect;	
  }
}
