/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expresionesregulares.ejemplo;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author RENZO
 */
public class ExpresionesRegulares {
    
    public static void main(String[] args) {
//        validaDni("73058123");
//        validaCelular("935 129 936");
        validaCorreo("renzo.chozo@correo.com");
    }
    
    public static void validaDni(String documento){
        Pattern patron = Pattern.compile("[0-9]{8}");//expresion regular a evaluar
        Matcher match = patron.matcher(documento);
        System.out.println("DNI Valido? " + match.matches());
    }
    
    public static void validaCelular(String nroCelular){
        Pattern patron = Pattern.compile("[0-9]{3}[\\s-][0-9]{3}[\\s-][0-9]{3}");//expresion regular a evaluar
        Matcher match = patron.matcher(nroCelular);
        System.out.println("Celular Valido? " + match.matches());
    }
    
    public static void validaCorreo(String correo){
        Pattern patron = Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9._-]+\\.[a-zA-Z]+");//expresion regular a evaluar
        Matcher match = patron.matcher(correo);
        System.out.println("Correo Valido? " + match.matches());
    }
    
}
