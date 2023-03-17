/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.m03poomorenodaniel;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danch
 */
//creamos la clase Casa
//Creamos los atributos
public class Casa {

    private String nif;
    private String nom;
    private Integer superficie;
    private ArrayList<Placa> dbplacas = new ArrayList<>();
    private ArrayList<Aparell> dbaparells = new ArrayList<>();
    private Boolean plomos = false;

    public void setPlomos() {
        plomos = true;
    }

    

    //creamos el constructor
    public Casa(String nif, String nom, Integer superficie, boolean plomos) {
        this.nif = nif;
        this.nom = nom;
        this.superficie = superficie;
        this.plomos = plomos;

    }
    
    //creamos los get para decir que en cualquier momento el usuario puede llamar a ese dato
    public String getNif() {
        return this.nif;
    }

    public String getNom() {
        return this.nom;
    }

    public Integer getSuperficie() {
        return this.superficie;
    }

    public Boolean getPlomos() {
        return plomos;
    }

    public ArrayList getLista() {
        return dbplacas;
    }

    //añadimos la placa a la lista
    public void setplaca(Placa x) {
        dbplacas.add(x);
    }
    
    
    
    public ArrayList getPlacas(){
        return dbplacas;
    }
    
    public ArrayList getAparells(){
        return dbaparells;
    }
    
//creo un metodo para meter una placa dentro de la lista dbplacas de la clase Casa
    public void agregarObjetoPlaca(Placa objetoplaca) {
      dbplacas.add(objetoplaca);
      
   }
    
    
    //creo un metodo para meter una placa dentro de la lista dbplacas de la clase Casa
    public void agregarObjetoAparell(Aparell objetoAparell) {
      dbaparells.add(objetoAparell);
      
   }
    
    
    
    
    
}
