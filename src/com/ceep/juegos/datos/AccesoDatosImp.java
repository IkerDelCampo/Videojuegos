
package com.ceep.juegos.datos;

import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.AccesoDatosEx;
import com.ceep.juegos.excepciones.EscrituraDatosEx;
import com.ceep.juegos.excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
            //El PritWriter te permite añadir la información al fichero y con anexar te permite sobreescribir o añadir
            PrintWriter escribir = new PrintWriter(new FileWriter(fichero, anexar));
            //esto me da un a especie de toString hecho por nosotros para pasrlo y verlo separados por ;
            escribir.println(juego.objetoPuntoComa());
            escribir.close();
            System.out.println("Juego añadido");
        } catch (IOException e) {
            throw new EscrituraDatosEx("Lo sentimos ocurrió un error con el archivo");
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
            lector.close();//siempre cerrar el archivo antes de devolver nada
            return -1;
        } catch (FileNotFoundException e) {
            throw new LecturaDatosEx("No se encontró el archivo");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Ocurrió un error al leer el archivo");
        }
    }

    @Override
    public List<Juego> listar(String nombreFichero) throws LecturaDatosEx {
        //creamos un array de tipo list
        List<Juego> juegos = new ArrayList<>();
        //creamos el fichero
        File fichero = new File(nombreFichero);
        // Creamos una "caja" donde guardaremos todos los objetos de tipo Juego
        Juego cajaJuego = null;
        try {
            //creamos un bufferedReader para lleer el contenido del archivo
            BufferedReader lector = new BufferedReader(new FileReader(fichero));
            //Declaramos un String para guardar lo que contiene cada linea
            String linea = lector.readLine();
            //empezamos a leer
            while(linea != null){
                //en esa "caja" creamos un objeto juego que contine la linea que lee
                cajaJuego = new Juego(linea);
                //añadimos al arrayList la "caja"
                juegos.add(cajaJuego);
                //siguiente linea
                linea = lector.readLine();
            }
            lector.close();
        } catch (FileNotFoundException e) {
            throw new LecturaDatosEx("No se encontró el archivo");
        } catch (IOException e){
            throw new LecturaDatosEx("Ocurrió un error al leer el archivo");
        }
        //Al final devolvemos el arrayList
        return juegos;
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
                    /*String contenidoLinea[] = linea.split(";");
                    String nombre = contenidoLinea[0];
                    int ventas = Integer.parseInt(contenidoLinea[1]);
                    double precio = Double.parseDouble(contenidoLinea[2]);
                    LocalDate salida = LocalDate.parse(contenidoLinea[3]);*/
                    return new Juego(linea);
                }
                linea = lector.readLine();
            }
            lector.close();
        } catch (FileNotFoundException e) {
            throw new LecturaDatosEx("No se encontró el archivo");
        } catch (IOException ex) {
            throw new LecturaDatosEx("Ocurrió un error al leer el archivo");
        }
        return null;
    }

    @Override
    public void deleteContenido(String nombreFichero, Juego juego) throws EscrituraDatosEx {
        File fichero = new File(nombreFichero);
        File ficheroTemporal = new File("Temporal"+nombreFichero);
        try {
            PrintWriter escribir = new PrintWriter(new FileWriter(ficheroTemporal, true));
            //inicio mi fichero
            BufferedReader lector = new  BufferedReader(new FileReader(fichero));
            //empiezo a leer la primera linea
            String linea = lector.readLine();
            while (linea != null) {
                if (linea.equalsIgnoreCase(juego.objetoPuntoComa())) {
                    linea = lector.readLine();
                }else{
                    escribir.println(linea);
                    linea = lector.readLine();
                } 
            }
            escribir.close();
            lector.close();
            //necesitamos cerrar tanto la lectura como la escritura antes de
            //borrar el archivo, de lo contrario este no ejecutara bien la acción
            fichero.delete();
            ficheroTemporal.renameTo(fichero);
        } catch (IOException e) {
            throw new EscrituraDatosEx("Ocurrió un error al leer el archivo");
        }
    }
    
}
