
package com.ceep.juegos.datos;

import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.AccesoDatosEx;
import com.ceep.juegos.excepciones.EscrituraDatosEx;
import com.ceep.juegos.excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AccesoDatosImp implements IAccesoDatos{

    @Override
    public boolean existeFichero(String nombreFichero) throws AccesoDatosEx {
        File fichero = new File(nombreFichero);
        return fichero.exists();
    }

    @Override
    public void addContenido(String nombreFichero, Juego juego, boolean anexar) throws EscrituraDatosEx {
        File fichero = new File(nombreFichero);
        try {
            BufferedReader lector = new  BufferedReader/*agrupa los caracteres*/(new FileReader(fichero)/*lee los caracteres*/);
            //
            String linea = lector.readLine();
            
        } catch (Exception e) {
        }
    }

    @Override
    public int buscarContenido(String nombreFichero, String busqueda) throws LecturaDatosEx {
        File fichero = new File(nombreFichero);
        int cont =0; 
        try {
            //inicio mi fichero
            BufferedReader lector = new  BufferedReader/*agrupa los caracteres*/(new FileReader(fichero)/*lee los caracteres*/);
            //empiezo a leer la primera linea
            String linea = lector.readLine();
            while (linea != null) {
                cont++;
                if (linea.equalsIgnoreCase(busqueda)) {
                    return cont;
                }
                linea = lector.readLine();
            }
            return -1;
        } catch (FileNotFoundException e) {
            throw new LecturaDatosEx("No se encontró el archivo");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Ocurrió un error al leer el archivo");
        }
    }

    @Override
    public List<Juego> listar(String nombreFichero) throws LecturaDatosEx {
        return null;
    }

    @Override
    public Juego cogerContenido(String nombreFichero, String nombreContenido) throws LecturaDatosEx {
        File fichero = new File(nombreFichero);
        try {
            //inicio mi fichero
            BufferedReader lector = new  BufferedReader/*agrupa los caracteres*/(new FileReader(fichero)/*lee los caracteres*/);
            //empiezo a leer la primera linea
            String linea = lector.readLine();
            while (linea != null) {
                if (linea.contains(nombreContenido)) {
                    String contenidoLinea[] = linea.split(";");
                    String nombre = contenidoLinea[0];
                    int ventas = Integer.parseInt(contenidoLinea[1]);
                    double precio = Double.parseDouble(contenidoLinea[2]);
                    LocalDate salida = LocalDate.parse(contenidoLinea[3]);
                    return new Juego(nombre,ventas,precio,salida);
                }
                linea = lector.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new LecturaDatosEx("No se encontró el archivo");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Ocurrió un error al leer el archivo");
        }
        return null;
    }

    @Override
    public void deleteContenido(String nombreFichero, Juego juego) throws EscrituraDatosEx {
        
    }
    
}
