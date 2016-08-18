/*
 * Copyright (C) 2016 Dhaby Xiloj <dhabyx@gmail.com>.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package archivobasico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dhaby Xiloj <dhabyx@gmail.com>
 */
public class ArchivoBasico {
    
    public void leerDeConsola() {
        String cadena = null;
        try {
            InputStreamReader entrada = new InputStreamReader(System.in);
            BufferedReader teclado = new BufferedReader(entrada);
            cadena = teclado.readLine();
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBasico.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            System.out.println(cadena);
        }
    }
    
    public void leerArchivo(String nombreArchivo){
        FileReader archivo;
        try {
            archivo = new FileReader(nombreArchivo);
            int c = archivo.read();
            while ( c != -1 ) {
                System.out.print((char)c);
                c = archivo.read();
            }
            archivo.close();
            System.out.println();
        } catch (FileNotFoundException ex) {
            System.out.println("No he encontrado el archivo: " +
                    nombreArchivo);
            Logger.getLogger( ArchivoBasico.class.getName() )
                    .log( Level.SEVERE, null, ex );
        } catch (IOException ex) {
            System.out.println("Tengo problemas de lectura en el archivo: " +
                    nombreArchivo);
            Logger.getLogger(ArchivoBasico.class.getName())
                    .log( Level.SEVERE, null, ex );
        }
    }
    
    public void escribirArchivo(String nombreArchivo){
        FileWriter archivo;
        try {
            archivo = new FileWriter(nombreArchivo);
            archivo.write("hola mundo\r\n");
            archivo.write("esta es otra línea");
            archivo.close();
        } catch (IOException ex) {
            System.out.println("Tengo problemas de escritura en el archivo: " + 
                    nombreArchivo);
            Logger.getLogger(ArchivoBasico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void escribirComoConsola(String nombreArchivo){
        PrintWriter archivo;
        try {
            archivo = new PrintWriter( new BufferedWriter(
                                            new FileWriter( nombreArchivo )
                                     ));
            archivo.println("hola");
            int a = 23;
            archivo.println(a);
            archivo.close();
        } catch (IOException ex) {
            System.out.println("Tengo problemas de escritura en el archivo: " +
                    nombreArchivo);
            Logger.getLogger(ArchivoBasico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
