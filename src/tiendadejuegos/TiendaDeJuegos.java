/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadejuegos;

import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.*;
import com.ceep.juegos.negocio.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Alumno Mañana
 */
public class TiendaDeJuegos {

    static Scanner teclado = new Scanner(System.in);

    public static void main(String[] args) {
        ICatalogoJuegos C1 = new CatalogoJuegosImp();
        menu();
        opciones(C1);
    }

    public static void menu() {
        System.out.println("");
        System.out.println("\t\tMENÚ");
        System.out.println("1.- Listar juegos:");
        System.out.println("2.- Añadir juego:");
        System.out.println("3.- Buscar posición juego:");
        System.out.println("4.- Eliminar juego:");
        System.out.println("5.- Combertir juego de texto a objeto:");
        System.out.println("0.- Salir:");
    }
    private static int pedirOpcion(){
        int opcion;
        while (true) {
            try {
                //me pide un número y si este no es un número "error" me lo pide de nuevo 
                opcion = Integer.parseInt(teclado.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Número no valido intentalo de nuevo");
            }
        }
        return opcion;
    }
    public static void opciones(ICatalogoJuegos datosCruciales) {
        int numero = pedirOpcion();
        while (numero != 0) {
            switch (numero) {
                case 1:
                    System.out.println("Introduzca el nombre del archivo con la extensión");
                    System.out.println("Ejemplo: archivo.txt");
                    try {
                        List<Juego> listaJuegos = datosCruciales.listarJuegos(teclado.nextLine());
                        for (int i = 0; i < listaJuegos.size(); i++) {
                            System.out.println(listaJuegos.get(i));
                        }
                        menu();
                    } catch (LecturaDatosEx e) {
                        System.out.println("Lo sentimos no se encontró el archivo");
                    }
                    break;
                case 2:
                    System.out.println("Introduzca el nombre del archivo con la extensión");
                    System.out.println("Ejemplo: archivo.txt");
                    String nombreArchivo = teclado.nextLine();
                    System.out.println("Introduzca nombre, unidades, precio y fecha de salida");
                    System.out.println("Ejemplo: nombre 200 29.45 2013-11-23");
                    Juego juegoAdd = new Juego(teclado.nextLine(), Integer.parseInt(teclado.nextLine()), Double.parseDouble(teclado.nextLine()), LocalDate.parse(teclado.nextLine()));
                    try {
                        datosCruciales.addJuego(nombreArchivo, juegoAdd);
                        menu();
                    } catch (EscrituraDatosEx e) {
                        System.out.println("Lo sentimos no se pudo escribir tu objeto");
                    } catch (AccesoDatosEx e) {
                        System.out.println("Lo sentimos no se pudo acceder al archivo");
                    }
                    break;
                case 3:
                    /*Seria bueno que lo localizase solo por el nombre*/
                    System.out.println("Introduzca el nombre del archivo con la extensión");
                    System.out.println("Ejemplo: archivo.txt");
                    nombreArchivo = teclado.nextLine();
                    System.out.println("Introduzca nombre, unidades, precio y fecha de salida separado por ; en una linea");
                    System.out.println("Ejemplo: nombre;200;29.45;2013-11-23");
                    String infoJuego =teclado.nextLine();
                    try {
                        System.out.println("Localizado en linea: "+datosCruciales.buscarJuego(nombreArchivo, infoJuego));
                        menu();
                    } catch (LecturaDatosEx e) {
                        System.out.println("Lo sentimos no se pudo encontrar el juego");
                    }
                    break;
                case 4:
                    System.out.println("Introduzca el nombre del archivo con la extensión");
                    System.out.println("Ejemplo: archivo.txt");
                    nombreArchivo = teclado.nextLine();
                    System.out.println("Introduzca nombre, unidades, precio y fecha de salida");
                    System.out.println("Ejemplo: nombre 200 29.45 2013-11-23");
                    Juego juegoDelete = new Juego(teclado.nextLine(), Integer.parseInt(teclado.nextLine()), Double.parseDouble(teclado.nextLine()), LocalDate.parse(teclado.nextLine()));
                    try {
                        datosCruciales.eliminarJuego(nombreArchivo, juegoDelete);
                        System.out.println("Juego eliminado del Catalogo");
                        menu();
                    } catch (EscrituraDatosEx e) {
                        System.out.println("Lo sentimos no se pudo eliminar tu objeto");
                    }
                    break;
                case 5:
                    System.out.println("Introduzca el nombre del archivo con la extensión");
                    System.out.println("Ejemplo: archivo.txt");
                    nombreArchivo = teclado.nextLine();
                    System.out.println("Introduzca nombre, unidades, precio y fecha de salida separado por ; en una linea");
                    System.out.println("Ejemplo: nombre;200;29.45;2013-11-23");
                    infoJuego =teclado.nextLine();
                    try {
                        System.out.println(datosCruciales.cogerJuego(nombreArchivo, infoJuego));
                        menu();
                    } catch (LecturaDatosEx e) {
                        System.out.println("Lo sentimos no se pudo combertir a objeto");
                    }
                    break;
                case 0:
                    break;
                default: System.out.println("opción incorrecta selecciones unadel 0 al 5");
            }
            numero = pedirOpcion();
        }
    }
}
