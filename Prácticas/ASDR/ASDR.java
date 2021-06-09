/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**
 *
 * @author Ray
 * 
 * a -- aBa (1)
 * b -- bAb (2)
 * b -- a   (3)
 */
public class ASDR {
    
    public String entrada = "abaaab";
    public int i = 0;
    
    public void consume(char x)
    {
        if(entrada.charAt(i) == x)
        {
            if(i<entrada.length())
            {
              i++;  
            }
        }
        else
        {
            System.exit(1);
        }
    }
    public void A()
    {
        consume('a');
        B();
        consume('a');
    }
    
    public void B()
    {
        switch(entrada.charAt(i))
        {
            case 'b':
                consume('b');
                A();
                consume('b');
                break;
            case 'a':
                consume('a');
                break;
            default:
                error("Intento consumir B() pero encontro b ni a");
        }
    }
    
    public void error(String msg)
    {
        System.out.println(msg);
        System.exit(1);
    }

    public void revisarGramatica()
    {
        A();
        if(entrada.charAt(i)=='\0')
        {
            System.out.println("Si pertenece a L(G) " + entrada);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ASDR asdr = new ASDR();
        asdr.revisarGramatica();
        
    }
    
}
