
package com.ceep.juegos.excepciones;

public class AccesoDatosEx extends Exception{
    //ya que todas extienden de la clase Exception,
    //requerimos de esto para crear nuestras propias exceciones ante estos casos
    //y de estas extenderan las otras excepciones
    /*ese es necesaria por si es imposible u orcurre un error al intentar
    acceder a un fichero*/
    public AccesoDatosEx (String alerta){
        super(alerta);
    }
}
