/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03poomorenodaniel;

/**
 *
 * @author danch
 */
public class Placa {

    private Integer superficie;
    private Float preu;
    private Integer potencia;

    public Placa(Integer superficie, Float preu, Integer potencia) {

        this.superficie = superficie;
        this.preu = preu;
        this.potencia = potencia;
    }

    public Integer getSuperficie() {
        return superficie;
    }

    public Float getPreu() {
        return preu;
    }

    public Integer getPotencia() {
        return potencia;
    }

}
