
package com.ceep.juegos.negocio;

import com.ceep.juegos.datos.AccesoDatosImp;
import com.ceep.juegos.datos.IAccesoDatos;
import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.*;
import java.util.List;

public class CatalogoJuegosImp implements ICatalogoJuegos{
    //Atributos
    private final IAccesoDatos datos;

    public CatalogoJuegosImp() {
        this.datos = new AccesoDatosImp();
    }
    
    @Override
    public void addJuego(String nombreFichero, Juego juego) throws AccesoDatosEx, EscrituraDatosEx{
        try {
            if(this.datos.existeFichero(nombreFichero)){
                this.datos.addContenido(nombreFichero, juego, true);
            }
            //Dentro del try puedo meter todos los catch que hagan falta
            //Importante establecer una jerarquia de hijo a padre
        } catch (EscrituraDatosEx e) {
            throw e;
        } catch (AccesoDatosEx e){
            throw e;
        }
    }

    @Override
    public int buscarJuego(String nombreFichero, String juego) throws LecturaDatosEx{
        try {
            return this.datos.buscarContenido(nombreFichero, juego);
        } catch (LecturaDatosEx e) {
            throw e;
        }
    }

    @Override
    public List<Juego> listarJuegos(String nombreFichero) throws LecturaDatosEx{
        try {
            return this.datos.listar(nombreFichero);
        } catch (LecturaDatosEx e) {
            throw e;
        }
    }

    @Override
    public Juego cogerJuego(String nombreFichero, String contenido) throws LecturaDatosEx{
        try {
            return this.datos.cogerContenido(nombreFichero, contenido);
        } catch (LecturaDatosEx e) {
            throw e;
        }
    }

    @Override
    public void eliminarJuego(String nombreFichero, Juego juego) throws EscrituraDatosEx{
        try {
            this.datos.deleteContenido(nombreFichero, juego);
        } catch (EscrituraDatosEx e) {
            throw e;
        }
    }
    
}
