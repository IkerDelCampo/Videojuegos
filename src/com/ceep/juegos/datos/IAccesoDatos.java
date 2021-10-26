
package com.ceep.juegos.datos;

import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.*;
import java.util.List;

/*Aqui definimos los metodos que despues 
implementaresmos en la clase AccesoDatos*/
public interface IAccesoDatos {
    //si no pons nada delnate de un metodo o funcion este será publico 
    //y abstracto en la clase tipo interfaz
    public abstract boolean existeFichero(String nombreFichero) throws AccesoDatosEx;
    void addContenido(String nombreFichero, Juego juego, boolean anexar/*añadir*/) throws EscrituraDatosEx;
    int buscarContenido(String nombreFichero, String busqueda) throws LecturaDatosEx;
    List<Juego>listar(String nombreFichero)throws LecturaDatosEx;
    Juego cogerContenido(String nombreFichero, String nombreContenido)throws LecturaDatosEx;//ganancias de un titulo
    void deleteContenido(String nombreFichero, Juego juego) throws EscrituraDatosEx;
    //int mayorUnidades(String nombreFichero) throws LecturaDatosEx; pasa a negocio
}
