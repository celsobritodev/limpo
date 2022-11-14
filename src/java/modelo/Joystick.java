/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author marcelosiedler
 */

public class Joystick implements Serializable {

    private static final long serialVersionUID = 1L;
  
    private Integer id;
   
    private String modelo;
    
    private int quantidadeBotoes;
   
    private Console numSerie;

    public Joystick() {
    }

    public Joystick(Integer id) {
        this.id = id;
    }

    public Joystick(Integer id, String modelo, int quantidadeBotoes) {
        this.id = id;
        this.modelo = modelo;
        this.quantidadeBotoes = quantidadeBotoes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQuantidadeBotoes() {
        return quantidadeBotoes;
    }

    public void setQuantidadeBotoes(int quantidadeBotoes) {
        this.quantidadeBotoes = quantidadeBotoes;
    }

    public Console getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Console numSerie) {
        this.numSerie = numSerie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Joystick)) {
            return false;
        }
        Joystick other = (Joystick) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Joystick[ id=" + id + " ]";
    }
    
}
