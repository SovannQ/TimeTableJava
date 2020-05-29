/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;


import java.sql.*;
import java.util.*;

public abstract class DAO<T> {
  protected Connection connect = null;
   
  public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * Méthode de création
  * @param obj
  * @return boolean 
  */
  public abstract boolean create(T obj);

  /**
  * Méthode pour effacer
  * @param obj
  * @return boolean 
  */
  public abstract boolean delete(T obj);

  /**
  * Méthode de mise à jour
  * @param obj
  * @param num
  * @return boolean
  */
  public abstract boolean update(T obj, int num);
  
   /**
  * Méthode de mise à jour
  * @param obj
  * @param nom
  * @return boolean
  */
  
  public abstract boolean updateNom(T obj, String nom);

  /**
  * Méthode de recherche des informations
  * @param id
  * @return T
  */
  public abstract T find(int id);
}