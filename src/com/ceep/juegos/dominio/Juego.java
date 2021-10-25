/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.juegos.dominio;

import java.util.Date;

/**
 *
 * @author Alumno Mañana
 */
public class Juego {
    //atributos
    private String nombre;
    private int unidadesVendidas;
    private double precioUnidad;
    private Date fechaSalida;//objeto https://www.discoduroderoer.es/clase-date-de-java/
    
    //constructor
    public Juego() {
    }
    
    //getter and setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getUnidadesVendidas() {
        return unidadesVendidas;
    }

    public void setUnidadesVendidas(int unidadesVendidas) {
        this.unidadesVendidas = unidadesVendidas;
    }

    public double getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
    
    //visualizar
    @Override
    public String toString() {
        return "Juego=" + nombre + ", unidadesVendidas=" + unidadesVendidas + ", precioUnidad=" + precioUnidad + ", fechaSalida=" + fechaSalida;
    }
    
    
}
