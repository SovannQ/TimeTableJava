/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.*;
import java.awt.GridLayout;
import javax.swing.*;

/**
 *
 * @author sovannquaglieri
 */
public class GererEtudiantsVue extends JFrame{
    
    private JPanel f_left;
    private JPanel f_right;
    private JPanel f_south;
    
    private JLabel nom;
    private JLabel mail;
    private JLabel mdp;
    private JLabel promo;
    private JLabel groupe;
    
    private JTextField nomTexte;
    private JTextField mailTexte;
    private JTextField mdpTexte;
    private JTextField promoTexte;
    private JTextField groupeTexte;
    
    private JButton ajouter;
    
    private JTable table;
    
    public GererEtudiantsVue(){
        
        setLayout(new BorderLayout());
        setSize(800, 600);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ça se ferme quand on clique
        setLocationRelativeTo(null); //au milieu de l'écran
        
        
        ajouter = new JButton("Ajouter un étudiant");
        
        table = new JTable();
         // creation des textes
     
        nomTexte = new JTextField();
        mailTexte = new JTextField();
        mdpTexte = new JTextField();
        promoTexte = new JTextField();
        groupeTexte = new JTextField();

        // creation des labels
   
        nom = new JLabel("Nom :", JLabel.LEFT);
        mail = new JLabel("mail :", JLabel.LEFT);
        mdp = new JLabel("mdp :", JLabel.LEFT);
        promo = new JLabel("promo :", JLabel.LEFT);
        groupe = new JLabel("groupe :", JLabel.LEFT);
        
        
        // creation des panneaux
        f_left = new JPanel();
        f_right = new JPanel();
        f_south = new JPanel();
        
        // mise en page des panneaux
        f_left.setLayout(new GridLayout(6, 2));
        f_right.setLayout(new GridLayout(1, 4));
        f_south.setLayout(new GridLayout(2, 1));
        
        // ajout des objets graphqiues dans les panneaux

        f_left.add(nom);
         f_left.add(nomTexte);
         
        f_left.add(mail);
        f_left.add(mailTexte);
        
        f_left.add(mdp);
        f_left.add(mdpTexte);
        
        f_left.add(promo);
         f_left.add(promoTexte);
         
   
        f_left.add(groupe);
       f_left.add(groupeTexte);
        
        
        f_left.add(ajouter);
        
        f_right.add(table);
        
        // disposition geographique des panneaux
        add("West", f_left);
        add("South", f_south);

 }
  
    
}
