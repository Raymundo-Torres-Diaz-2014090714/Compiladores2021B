/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thompson;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Ray
 */
public class mainThompson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        algoritmo proceso = new algoritmo();
        Scanner sc = new Scanner(System.in); //Se crea el lector
        System.out.println("Ingrese su expresión regular");//Se pide un dato al usuario
        String expresionRegular = sc.nextLine();
        System.out.println(""+expresionRegular);
        proceso.separaCaracteres(expresionRegular);
        proceso.recorrerPila();
        proceso.recorreLista();
    }
    
}
