/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03poomorenodaniel;

/**
 *
 * @author danch
 */
public class Aparell {

    private String descripcio;
    private Integer potencia;
    private Boolean plomoAparell = false;

    public Aparell(String descripcio, Integer potencia) {

        this.descripcio = descripcio;
        this.potencia = potencia;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public Integer getPotencia() {
        return potencia;
    }

    public Boolean getPlomoAparell() {
        return plomoAparell;
    }
    
    //enciendo los plomos d eaparell
    public void onAparell() {
        plomoAparell = true;
    }
    //apagamos los plomos de aparell
    public void offAparell() {
        plomoAparell = false;
    }

    public void setPlomosAparell() {
        plomoAparell = true;
    }
}
