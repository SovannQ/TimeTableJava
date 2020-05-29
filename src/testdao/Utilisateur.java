/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;
import java.sql.*;
import java.util.*;
/**
 *
 * @author titir
 */
public class Utilisateur {
    //ID
  private int id = 0;
  //Mail utilisateur
  private String mail = "";
  //mdp
  private String password = "";
  //nom
  private String nom="";
  //prenom
  private String prenom="";
  //droits
  private int droit=0;
   
  public Utilisateur(int id, String mail, String password, String nom, String prenom, int droit) {
    this.id = id;
    this.mail = mail;
    this.password = password;
    this.nom = nom;
    this.prenom = prenom;
    this.droit = droit;
  }

  public Utilisateur(){};
     
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getMail() {
    return mail;
  }

  public void setMail(String mail) {
    this.mail = mail;
  }

    public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
    public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }
    public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }
  
  public int getDroit() {
    return droit;
  }

  public void setDroit(int droit) {
    this.droit = droit;
  }   
}
