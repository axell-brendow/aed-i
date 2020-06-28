/*

PUC Minas - Ciencia da Computacao     Nome: Exercicio5

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 09/04/2018

*/

import IO.*;

public class Exercicio5
{
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exercicio5");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        int n, r = 1, c = 0, s = -1;
        
        n = IO.readint("Qual a quantidade? ");
        
        while (r < n) // mudanca de r <= n para r < n
        {
            if (c % 2 == 0) c = c - s;
            
            else c = c * s;
            
            IO.println(r + " " + c); // mudanca de (r - 1) para r
            
            c = c + 1;
            r = r + 1;
        }
        
        IO.println(r + " " + (c + 1));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
