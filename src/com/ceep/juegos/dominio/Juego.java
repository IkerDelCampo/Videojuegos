/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ceep.juegos.dominio;

import java.time.LocalDate;

/**
 *
 * @author Alumno Mañana
 */
public class Juego {

    //atributos
    private String nombre;
    private int unidadesVendidas;
    private double precioUnidad;
    private LocalDate fechaSalida;//objeto año-mes -dia

    //constructor
    public Juego() {
    }

    public Juego(String nombre, int unidadesVendidas, double precioUnidad, LocalDate fechaSalida) {
        this.nombre = nombre;
        this.unidadesVendidas = unidadesVendidas;
        this.precioUnidad = precioUnidad;
        this.fechaSalida = fechaSalida;
    }

    public Juego(String datos) {// en esta linea creamos el objeto con la informacion que le damos "datos"
        //Q ue a su vez contiene y le pasa linea desde coger contenido IAccesoDatos
        String contenidoDatos[] = datos.split(";");
        this.nombre = contenidoDatos[0];
        this.unidadesVendidas = Integer.parseInt(contenidoDatos[1]);
        this.precioUnidad= Double.parseDouble(contenidoDatos[2]);
        this.fechaSalida = LocalDate.parse(contenidoDatos[3]);
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

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String objetoPuntoComa(){
        return nombre+";"+unidadesVendidas+";"+precioUnidad+";"+fechaSalida;
    }
    
    @Override
    public String toString() {
        return "Juego=" + nombre + ", unidadesVendidas=" + unidadesVendidas + ", precioUnidad=" + precioUnidad + ", fechaSalida=" + fechaSalida;
    }

}
