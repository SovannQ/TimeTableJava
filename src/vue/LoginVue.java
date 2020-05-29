/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import com.mysql.jdbc.PreparedStatement;
import controleur.LoginControleur;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import testdao.connection;

/**
 *
 * @author sovannquaglieri
 */
public class LoginVue extends JFrame {
    
    public JPanel loginPanel;             // To reference a panel
    //----------------------------------------------------------
    private JLabel emailLabel;      // To reference a email   
    private JLabel passwordLabel;      // To reference a password   
 
    //----------------------------------------------------------
    private JTextField emailTextField; // To reference a text field
    private JPasswordField passwordTextField; // To reference a text field
 
     //----------------------------------------------------------
    private JButton loginButton;       // To reference a button
    
     
    public LoginVue(){
       
        setSize (700, 300); // donne une taille en hauteur et largeur à la fenêtre
        setTitle ("CONNEXION"); // donne un titre à la fenêtre
       
        buildPanelLogin();
        add(loginPanel);
        
      
       setVisible(true); //visible est la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ça se ferme quand on clique
        setLocationRelativeTo(null); //au milieu de l'écran

    }
    
   
    private void buildPanelLogin(){

       // Create a label to display instructions.
      emailLabel = new JLabel("Mail: ");

      // Create a username 20 characters wide.
      emailTextField = new JTextField(20);
      
      // Create a label to display instructions.
      passwordLabel = new JLabel("Mot de passe: ");
     
      setLayout(new GridLayout(0, 2));
      // Create a text field 10 characters wide.
      passwordTextField = new JPasswordField(20);
      
         // Create a button with the caption "Calculate".
      loginButton = new JButton("Se connecter");

      // Add an action listener to the button.
      loginButton.addActionListener(new button_login());
      
      loginPanel = new JPanel();
      
      loginPanel.add(emailLabel);
      loginPanel.add(emailTextField);
      loginPanel.add(passwordLabel);
      loginPanel.add(passwordTextField);
      loginPanel.add(loginButton);

      add(loginPanel);
      
   }
   
    
    private class button_login implements ActionListener
   {
      /**
         The actionPerformed method executes when the user
         clicks on the Calculate button.
         @param e The event object.
      */

      public void actionPerformed(ActionEvent e)
      {
          //1. db connexion
          
          connection dbConnect = new connection();
          
          //2. récupérer les infos des boxs
          
           String username = emailTextField.getText();
           String password = String.valueOf(passwordTextField.getPassword()); // converting the password into string
         
      }
    }
}

