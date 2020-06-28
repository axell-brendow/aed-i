/*

PUC Minas - Ciência da Computação     Nome: Exemplo0094

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/03/2018

*/

import IO.*;

public class Exemplo0094
{
    /**
     * Mostra os inversos dos multiplos de 3 em ordem crescente
     * @param number Quantidade de multiplos a mostrar
     */
    
    public static void showSomeInversesOfMultiplesOfThree(int number)
    {
        // percorre a quantidade de multiplos a mostrar
        for (int i = 0; i < number; i++)
        {
            if (i == 0)
            {
                IO.println("1/(3 ^ 0) = 1");
            }
            
            else
            {
                IO.println("1/(3 x " + i + ") = 1/" + 3 * i);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfMultiples;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0094");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfMultiples = IO.readint("Informe a quantidade de multiplos de 3: ");
            IO.println();
            
        } while(numberOfMultiples < 1);
        
        // mostra os inversos dos multiplos de tres
        showSomeInversesOfMultiplesOfThree(numberOfMultiples);
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
