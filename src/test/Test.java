
package test;

import com.ceep.juegos.datos.AccesoDatosImp;
import com.ceep.juegos.datos.IAccesoDatos;
import com.ceep.juegos.dominio.Juego;
import com.ceep.juegos.excepciones.EscrituraDatosEx;
import com.ceep.juegos.excepciones.LecturaDatosEx;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    //public static void main(String[] args) throws IOException, EscrituraDatosEx, LecturaDatosEx {
        String nombreArchivo= "patata.txt";
        File patata =new File(nombreArchivo);
        Juego j1 = new Juego("lol", 2, 2000, LocalDate.parse("2012-11-20"));
        Juego j2 = new Juego("lel", 2, 2000, LocalDate.parse("2012-11-20"));
        Juego j3 = new Juego("oky", 2, 2000, LocalDate.parse("2012-11-20"));
        IAccesoDatos ac = new AccesoDatosImp();
        /*ac.addContenido(nombreArchivo, j1, true);
        ac.addContenido(nombreArchivo, j2, true);
        ac.addContenido(nombreArchivo, j3, true);*/
        /*Juego prueva = ac.cogerContenido(nombreArchivo, "lol");
        System.out.println(prueva.toString());*/
        //ac.deleteContenido(nombreArchivo, j2); //Borrar un objeto
        //System.out.println(ac.listar(nombreArchivo));
        //System.out.println(ac.cogerContenido(nombreArchivo, "manzana;3;3000.0;2013-11-23"));
        //System.out.println(ac.buscarContenido(nombreArchivo, "manzana;3;3000.0;2013-11-23"));
    //}
}
