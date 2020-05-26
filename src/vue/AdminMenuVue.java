/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.*;

import javax.swing.*;
import testdao.connection;


/**
 *
 * @author sovannquaglieri
 */
public class AdminMenuVue extends JFrame{
    
    public JPanel adminMenuPanel;             // To reference a panel
    //----------------------------------------------------------
 
    private JButton GererEtudiantsButton;       // To reference a button
    private JButton GererProfsButton;       // To reference a button
    private JButton GererSeancesButton;       // To reference a button
    
    
    public AdminMenuVue(){
    
        setSize (700, 300); // donne une taille en hauteur et largeur à la fenêtre
        setTitle ("Menu administrateur"); // donne un titre à la fenêtre
       
        buildPanelLogin();
        add(adminMenuPanel);
        
      
        setVisible(true); //visible est la fenêtre
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ça se ferme quand on clique
        setLocationRelativeTo(null); //au milieu de l'écran
        
        
        
    }
    
     private void buildPanelLogin(){

         // Create a button with the caption "Calculate".
      GererEtudiantsButton = new JButton("Gérer étudiants");
      GererProfsButton = new JButton("Gérer profs");
      GererSeancesButton = new JButton("Gérer séances");

      // Add an action listener to the button.
      GererEtudiantsButton.addActionListener(new button_GererEtudiants());
      GererProfsButton.addActionListener(new button_GererProfs());
      GererSeancesButton.addActionListener(new button_GererSeances());
      
      adminMenuPanel = new JPanel();
      
      adminMenuPanel.add(GererEtudiantsButton);
      adminMenuPanel.add(GererProfsButton);
      adminMenuPanel.add(GererSeancesButton);

      add(adminMenuPanel);
      
   }
     
     
      private class button_GererEtudiants implements ActionListener
   {
    
      public void actionPerformed(ActionEvent e)
      {
          System.out.println("it's lit");
         
      }
    }
      
      private class button_GererProfs implements ActionListener
   {
    
      public void actionPerformed(ActionEvent e)
      {
         
         
      }
    }
      
      private class button_GererSeances implements ActionListener
   {
    
      public void actionPerformed(ActionEvent e)
      {
         
         
      }
    }
    
}
