/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue;

import controleur.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import testdao.connection;

/**
 *
 * @author Sovann
 */
public class TimeTableVue extends JFrame{
    
    private JPanel top;
    private JPanel left;
    private JPanel middle;
    private JPanel right;
    private JPanel bottom;
    
    private JLabel weeks;
    private JTable edt;
    private JTable hours;
    private TableColumn colonne;
    
    
    private JButton cours;
    private JButton etudiants;
    private JButton profs;
    
    private JComboBox listeEtu;
    private JCheckBox listeProfs;
    
    
    private JButton rechercher; 
    private String etudiant;
    
   public TimeTableVue(){
       
       setLayout(new BorderLayout());
       setTitle("Emploi du temps");
       setSize(1700,900);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ça se ferme quand on clique
       setLocationRelativeTo(null); //au milieu de l'écran
       
       
       JPanel middle = new JPanel();
       JPanel top = new JPanel();
       JPanel bottom = new JPanel();
       
       //middle.setPreferredSize(new Dimension(640, 480));
       middle.setBackground(Color.LIGHT_GRAY);
       
       top.setBackground(Color.GRAY);
       top.setPreferredSize(new Dimension(100, 100));
       
       bottom.setBackground(Color.GRAY);
       bottom.setPreferredSize(new Dimension(100, 100));
       
       //weeks = new JLabel("Semaine", JLabel.LEFT); // si le boutton "semaine 1 est appuyé, sql = select * from seance where semaine = 1;
       
       //top.add(weeks);
       
       edt = new JTable();
       edt.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{" ","LUNDI", "MARDI", "MERCREDI", "JEUDI","VENDREDI", "SAMEDI","DIMANCHE"}));
                
       edt.setRowHeight(125);
       colonne = edt.getColumnModel().getColumn(0);
       colonne.setPreferredWidth(125);
       
       colonne = edt.getColumnModel().getColumn(1);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(2);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(3);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(4);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(5);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(6);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(7);
       colonne.setPreferredWidth(250);
       
       //////////////////////////////////////////////////////////////// LIGNE 1 8h30
       
       DefaultTableModel line1 = (DefaultTableModel) edt.getModel();
       line1.addRow(new Object[]{"8h30"});
       //////////////////////////////////////////////////////////////// LIGNE 2 10H
       
       DefaultTableModel line2 = (DefaultTableModel) edt.getModel();
       line2.addRow(new Object[]{"10h"});
       ////////////////////////////////////////////////////////////////
       
       DefaultTableModel line3 = (DefaultTableModel) edt.getModel();
       line3.addRow(new Object[]{"11h30"});
       ////////////////////////////////////////////////////////////////
       
       DefaultTableModel line4 = (DefaultTableModel) edt.getModel();
       line4.addRow(new Object[]{"13h"});
       ////////////////////////////////////////////////////////////////
       
        DefaultTableModel line5 = (DefaultTableModel) edt.getModel();
       line5.addRow(new Object[]{"14h30"});
       ////////////////////////////////////////////////////////////////
       
       DefaultTableModel line6 = (DefaultTableModel) edt.getModel();
       line6.addRow(new Object[]{"16h00"});
       
       
       
        middle.add(edt.getTableHeader(), BorderLayout.CENTER);
        middle.add(edt, BorderLayout.CENTER);
        
        hours = new JTable();
        hours.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{" ","LUNDI", "MARDI", "MERCREDI", "JEUDI","VENDREDI", "SAMEDI","DIMANCHE"}));
        
        
        cours = new JButton("Cours");
        cours.setBorder((Border) new RoundedBorder(5));
        etudiants = new JButton("Etudiants");
        etudiants.setBorder((Border) new RoundedBorder(5));
        profs = new JButton("Profs");
        profs.setBorder((Border) new RoundedBorder(5));
        
        rechercher = new JButton("rechercher");
        
        rechercher.addActionListener(new search());
        bottom.add(cours,BorderLayout.WEST);
        bottom.add(etudiants);
        bottom.add(profs);
        
        listeEtu = new JComboBox();
        
        FillComboBox();
       
        top.add(listeEtu);
        
        top.add(rechercher);
       add("Center",middle);
       add("North",top);
       add("South",bottom);
       
       
   }
   
    public TimeTableVue(GererEtudiantsControleur EmploiDuTemps){
       
       setLayout(new BorderLayout());
       setTitle("Emploi du temps");
       setSize(1700,900);
       setVisible(true);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //ça se ferme quand on clique
       setLocationRelativeTo(null); //au milieu de l'écran
       
       
       JPanel middle = new JPanel();
       JPanel top = new JPanel();
       JPanel bottom = new JPanel();
       
       //middle.setPreferredSize(new Dimension(640, 480));
       middle.setBackground(Color.LIGHT_GRAY);
       
       top.setBackground(Color.GRAY);
       top.setPreferredSize(new Dimension(100, 100));
       
       bottom.setBackground(Color.GRAY);
       bottom.setPreferredSize(new Dimension(100, 100));
       
       //weeks = new JLabel("Semaine", JLabel.LEFT); // si le boutton "semaine 1 est appuyé, sql = select * from seance where semaine = 1;
       
       //top.add(weeks);
       
       edt = new JTable();
       edt.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{" ","LUNDI", "MARDI", "MERCREDI", "JEUDI","VENDREDI", "SAMEDI","DIMANCHE"}));
                
       edt.setRowHeight(125);
       colonne = edt.getColumnModel().getColumn(0);
       colonne.setPreferredWidth(125);
       
       colonne = edt.getColumnModel().getColumn(1);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(2);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(3);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(4);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(5);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(6);
       colonne.setPreferredWidth(250);
       
       colonne = edt.getColumnModel().getColumn(7);
       colonne.setPreferredWidth(250);
       
       //////////////////////////////////////////////////////////////// LIGNE 1 8h30
       
       DefaultTableModel line1 = (DefaultTableModel) edt.getModel();
       line1.addRow(new Object[]{EmploiDuTemps.getEleve().getNum(),EmploiDuTemps.getGroupe().getNom()});
       //////////////////////////////////////////////////////////////// LIGNE 2 10H
       
       DefaultTableModel line2 = (DefaultTableModel) edt.getModel();
       line2.addRow(new Object[]{"10h"});
       ////////////////////////////////////////////////////////////////
       
       DefaultTableModel line3 = (DefaultTableModel) edt.getModel();
       line3.addRow(new Object[]{"11h30"});
       ////////////////////////////////////////////////////////////////
       
       DefaultTableModel line4 = (DefaultTableModel) edt.getModel();
       line4.addRow(new Object[]{"13h"});
       ////////////////////////////////////////////////////////////////
       
        DefaultTableModel line5 = (DefaultTableModel) edt.getModel();
       line5.addRow(new Object[]{"14h30"});
       ////////////////////////////////////////////////////////////////
       
       DefaultTableModel line6 = (DefaultTableModel) edt.getModel();
       line6.addRow(new Object[]{"16h00"});
       
       
       
        middle.add(edt.getTableHeader(), BorderLayout.CENTER);
        middle.add(edt, BorderLayout.CENTER);
        
        hours = new JTable();
        hours.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{" ","LUNDI", "MARDI", "MERCREDI", "JEUDI","VENDREDI", "SAMEDI","DIMANCHE"}));
        
        
        cours = new JButton("Cours");
        cours.setBorder((Border) new RoundedBorder(5));
        etudiants = new JButton("Etudiants");
        etudiants.setBorder((Border) new RoundedBorder(5));
        profs = new JButton("Profs");
        profs.setBorder((Border) new RoundedBorder(5));
        
        rechercher = new JButton("rechercher");
        
        rechercher.addActionListener(new search());
        bottom.add(cours,BorderLayout.WEST);
        bottom.add(etudiants);
        bottom.add(profs);
        
        listeEtu = new JComboBox();
        
        FillComboBox();
       
        top.add(listeEtu);
        
        top.add(rechercher);
       add("Center",middle);
       add("North",top);
       add("South",bottom);
       
       
   }
   
   
   
    public static void main(String[] s) {
         
        // creation de la fenetre
       TimeTableVue edt = new TimeTableVue();
    }
    
    private static class RoundedBorder implements Border {

    private int radius;


    RoundedBorder(int radius) {
        this.radius = radius;
    }


    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }


    public boolean isBorderOpaque() {
        return true;
    }


    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        g.drawRoundRect(x, y, width-1, height-1, radius, radius);
    }
}
    
    public void FillComboBox(){
     
        try{
            
            connection conn = new connection();
            
            String myQuery = " SELECT * from utilisateur WHERE Droit=2 ";
            
            PreparedStatement ps = (PreparedStatement) conn.getInstance().prepareStatement(myQuery);
               
                
                ResultSet rs = ps.executeQuery();
              while(rs.next())
              {
                  listeEtu.addItem(rs.getString(1) + " - " + rs.getString(4) + " " + rs.getString(5) );  
                  
              }
              
             
              
        }
         
        
        catch (Exception r) {
                System.err.println("Got an exception!");
                System.err.println(r.getMessage());
            }
        
   
    }
    
     private class search implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            
            try {
                String etudiant = (String)listeEtu.getSelectedItem().toString();
                
                String arr[] = etudiant.split(" ", 2);
                String ID = arr[0];
                int Id = Integer.parseInt(ID);
                System.out.println(ID);
                GererEtudiantsControleur EmploiDuTemps = new GererEtudiantsControleur(Id);
                 // creation de la fenetre
                TimeTableVue edt = new TimeTableVue(EmploiDuTemps);
            } 
            
            
            catch (Exception r) {
                System.err.println("Got an exception!");
                System.err.println(r.getMessage());
            }

            //setVisible(false);
        }

    }
    
}
