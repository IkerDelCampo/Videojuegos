
package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Test {
    public static void main(String[] args) throws IOException {
        File patata =new File("patata.txt");
        try {
            BufferedReader lector = new  BufferedReader/*agrupa los caracteres*/(new FileReader(patata)/*lee los caracteres*/);
            lector.skip(1l);
            System.out.println(lector.readLine());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
