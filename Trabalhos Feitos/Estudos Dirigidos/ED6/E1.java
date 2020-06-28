/*

PUC Minas - Ciência da Computação     Nome: E1

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 20/03/2018

*/

import IO.*;

public class E1
{
    static String expression = ""; // guardara' a expressao numerica
    
    /**
     * f ( x, n ) = 1 + x1 + x2 + x3 + x4 + ... + xn
     * @param x base das potencias
     * @param n expoente maximo
     * @return imagem de x e n
     */
    
    public static double function(double x, int n)
    {
        double image = 0;
        
        if (n >= 0)
        {
            image += Math.pow(x, n) + function(x, n - 1);
            expression += x + "^" + n + " + "; // vai montando a expressao numerica
        }
        
        return image;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        double x, image;
        int n;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E1");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            x = IO.readdouble("Informe a base das potencias (x): ");
            IO.println();
            
        } while (x == 0); // evitara' entradas nao numericas
        
        do
        {
            n = IO.readint("Informe o expoente maximo (n): ");
            IO.println();
            
        } while (x < 1);
        
        image = function(x, n);
        
        // remove o ultimo: "+ "
        expression = expression.substring(0, expression.length() - 2);
        
        IO.println("f(x, n) = " + expression + "= " + image);
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
