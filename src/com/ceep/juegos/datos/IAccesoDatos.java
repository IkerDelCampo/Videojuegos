
package com.ceep.juegos.datos;

import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.*;

/*Aqui definimos los metodos que despues 
implementaresmos en la clase AccesoDatos*/
public interface IAccesoDatos {
    //si no pons nada delnate de un metodo o funcion este será publico 
    //y abstracto en la clase tipo interfaz
    public abstract boolean existeFichero(String nombreFichero) throws AccesoDatosEx;
    void addContenido(String nombreFichero, Juego juego, boolean anexar/*añadir*/) throws EscrituraDatosEx;
    void buscarContenido() throws LecturaDatosEx;
}
