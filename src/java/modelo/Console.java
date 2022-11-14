/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author marcelosiedler
 */

public class Console implements Serializable {

    private static final long serialVersionUID = 1L;
    private Integer numSerie;
    private String nome;
    private String marca;
   
    private BigDecimal valor;
    
    private List<Joystick> joystickList;

    public Console() {
    }

    public Console(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public Console(Integer numSerie, String nome, String marca, BigDecimal valor) {
        this.numSerie = numSerie;
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
    }

    public Integer getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(Integer numSerie) {
        this.numSerie = numSerie;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public List<Joystick> getJoystickList() {
        return joystickList;
    }

    public void setJoystickList(List<Joystick> joystickList) {
        this.joystickList = joystickList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (numSerie != null ? numSerie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Console)) {
            return false;
        }
        Console other = (Console) object;
        if ((this.numSerie == null && other.numSerie != null) || (this.numSerie != null && !this.numSerie.equals(other.numSerie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Console[ numSerie=" + numSerie + " ]";
    }
    
}
