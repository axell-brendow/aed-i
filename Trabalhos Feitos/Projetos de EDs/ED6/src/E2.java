/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 20/03/2018

*/

import IO.*;

public class E2
{
    static String expression = ""; // guardara' a expressao numerica
    
    /**
     * e = 1 + 1/1 + 1/2 + 1/3 + 1/4 + ... + 1/(n-1)
     * @param n sucessor do denominador maximo
     * @return imagem de n
     */
    
    public static double function(int n)
    {
        double image = 0;
        
        if (n - 1 > 0)
        {
            image += 1/(n - 1) + function(n - 1);
            expression += "1/" + (n - 1) + " + "; // vai montando a expressao numerica
        }
        
        else if (n - 1 == 0)
        {
            image += 1; // a ultima funcao somara' um
            expression += "1 + "; // esse sera' o comeco da expressao
        }
        
        return image;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        double image;
        int n;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            n = IO.readint("Informe o sucessor do denominador maximo (n): ");
            IO.println();
            
        } while (n < 1);
        
        image = function(n);
        
        // remove o ultimo: "+ "
        expression = expression.substring(0, expression.length() - 2);
        
        IO.println("e = " + expression + "= " + image);
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
