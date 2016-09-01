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
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
                System.out.println("n:"+ Integer.toHexString(c) 
                                    +" c:"+(char)c);
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
    
    public void escribirConBuffer(String nombreArchivo){
        try {
            BufferedWriter archivo = new BufferedWriter(new FileWriter(nombreArchivo));
            archivo.write("Hola Mundo");
            archivo.newLine();
            archivo.append("Esta es una prueba");
            archivo.flush();
            archivo.close();
        } catch (IOException ex) {
            System.out.println("Tengo problemas de escritura en el archivo: "+ nombreArchivo);
            Logger.getLogger(ArchivoBasico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void lecturaBinaria(String nombreArchivo){
        try {
            FileInputStream archivo = new FileInputStream(nombreArchivo);
            DataInputStream stream = new DataInputStream(archivo);
            char c;
            c = (char)stream.readByte();
            int i = stream.readInt();
            stream.close();
            System.out.println("Caracter: "+c+" entero: "+i);
            byte n1 = (byte) (i >>24);
            byte n2 = (byte) (i >>16);
            byte n3 = (byte) (i >>8);
            byte n4 = (byte) (i);
            System.out.println("cadena de int: "+(char)n1+(char)n2+(char)n3+(char)n4);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoBasico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBasico.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void escrituraBinaria(String nombreArchivo){
        try {
            FileOutputStream archivo = new FileOutputStream(nombreArchivo);
            DataOutputStream stream = new DataOutputStream(archivo);
            stream.writeBytes("Hello world");
            stream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArchivoBasico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArchivoBasico.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public void propiedadesDelSistema() {
        System.out.println(System.getProperty("file.separator"));
        System.out.println(System.getProperty("java.home"));
        System.out.println(System.getProperty("java.version"));
        System.out.println(System.getProperty("line.separator"));
        System.out.println(System.getProperty("os.arch"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("os.version"));
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));
        System.out.println(System.getProperty("user.name"));
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArchivoBasico archivo = new ArchivoBasico();
        
    }
    
}
