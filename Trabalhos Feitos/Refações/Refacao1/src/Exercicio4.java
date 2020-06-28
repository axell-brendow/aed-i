/*

PUC Minas - Ciencia da Computacao     Nome: Exercicio4

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 09/04/2018

*/

import IO.*;

public class Exercicio4
{
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        double a, b;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exercicio4");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            a = IO.readdouble("Informe a: ");
            IO.println();
            
        } while (a <= 0);
        
        do
        {
            b = IO.readdouble("Informe b: ");
            IO.println();
            
        } while (b <= 0 || a <= b);
        
        IO.println("Area hachurada: " + 2 * (a * b) / 3);
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
