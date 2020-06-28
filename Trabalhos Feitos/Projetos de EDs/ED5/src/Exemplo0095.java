/*

PUC Minas - Ciência da Computação     Nome: Exemplo0095

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/03/2018

*/

import IO.*;

public class Exemplo0095
{
    /**
     * Mostra os elementos da PG
     * @param number Quantidade de multiplos a mostrar
     */
    
    public static void showPG(int number)
    {
        // percorre a quantidade de multiplos a mostrar
        for (int i = 0; i < number; i++)
        {
            IO.println("1/(3 ^ " + i + ") = 1/" + (int) Math.pow(3, i));
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfMultiples;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0095");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfMultiples = IO.readint("Informe a quantidade de elementos da PG: ");
            IO.println();
            
        } while(numberOfMultiples < 1);
        
        showPG(numberOfMultiples);
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
