
package com.ceep.juegos.negocio;

import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.*;
import java.util.List;

public interface ICatalogoJuegos {
    //Añadir un juego al "catalogo"
    void addJuego(String nombreFichero, Juego juego) throws AccesoDatosEx, EscrituraDatosEx;
    
    //buscar un juego en un "Catalogo"
    int buscarJuego(String nombreFichero, String juego) throws LecturaDatosEx;//cadena
    
    //Mostrar todos los juegos del "Catalogo"
    List<Juego> listarJuegos(String nombreFichero) throws LecturaDatosEx;//cadena
    
    //Cadena que permite pasar texto a objeto "Catalogo"
    Juego cogerJuego(String nombreFichero, String contenido) throws LecturaDatosEx;//es una cadena de cogerContenido en la capa inferior
    
    //Eliminar juego de un "Catalogo"
    void eliminarJuego(String nombreFichero, Juego juego) throws EscrituraDatosEx;
    
}
