/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdao;

/**
 *
 * @author titir
 */
public class SeanceSalle {
    private int IdSeance;
    private int IdSalle;

    public SeanceSalle(int IdSeance, int IdSalle) {
        this.IdSeance = IdSeance;
        this.IdSalle = IdSalle;
    }

    public SeanceSalle() {
    }

    public int getIdSeance() {
        return IdSeance;
    }

    public int getIdSalle() {
        return IdSalle;
    }

    public void setIdSeance(int IdSeance) {
        this.IdSeance = IdSeance;
    }

    public void setIdSalle(int IdSalle) {
        this.IdSalle = IdSalle;
    }
    
}
