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
public class SeanceGroupe {
    private int IdSeance;
    private int IdGroupe;

    public SeanceGroupe(int IdSeance, int IdGroupe) {
        this.IdSeance = IdSeance;
        this.IdGroupe = IdGroupe;
    }

    public SeanceGroupe() {
    }

    public int getIdSeance() {
        return IdSeance;
    }

    public int getIdGroupe() {
        return IdGroupe;
    }

    public void setIdSeance(int IdSeance) {
        this.IdSeance = IdSeance;
    }

    public void setIdGroupe(int IdGroupe) {
        this.IdGroupe = IdGroupe;
    }
    
}
