/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Thompson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Ray
 */
public class algoritmo {
    
    Stack<String> pilaExp = new Stack<String>();
    Stack<String> pilaAux = new Stack<String>();
    ArrayList<objetoArista> listaAristas = new ArrayList();
    
    public void separaCaracteres(String expresion)
    {
        int i = 0;
        for(i=0; i<expresion.length(); i++)
        {
            pilaExp.push(String.valueOf(expresion.charAt(i)));
        }
        System.out.println(Arrays.toString(pilaExp.toArray()));
    }
    
    public void recorrerPila()
    {
        pilaAux = pilaExp;
        int i = 0;
        String caracter = "";
        
        int contId = 0;
        objetoArista arista = null;
        for(i=0; i < pilaAux.size(); i++)
        {
            caracter = pilaAux.pop();
            if(!caracter.equals("|") || !caracter.equals("*") || !caracter.equals("+") || !caracter.equals("(") || !caracter.equals(")"))
            {
                arista = new objetoArista();
                arista.setCaracter(caracter);
                arista.setNodoInicio(contId);
                contId++;
                arista.setNodoFin(contId);
                listaAristas.add(arista);
            }
        }
    }
    
    public void recorreLista()
    {
        int i = 0;
        objetoArista arista = null;
        for(i=0;i < listaAristas.size(); i++)
        {
            arista = listaAristas.get(i);
            System.out.println("Inicio: " + arista.getNodoInicio() + " Caracter : " + arista.getCaracter() + " Fin : " + arista.getNodoFin());
        }
    }
    
    
}
