/*

PUC Minas - Ciência da Computação     Nome: Exemplo0093

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/03/2018

*/

import IO.*;

public class Exemplo0093
{
    /**
     * Mostra multiplos de 3 que sao impares em ordem decrescente
     * @param number Quantidade de multiplos a mostrar
     */
    
    public static void showSomeMultiplesOfThree(int number)
    {
        int j = number * 2 - 1; // fator de multiplicacao
        
        // percorre a quantidade de multiplos a mostrar
        for (int i = number; i > 0; i--)
        {
            IO.println("3 x " + j + " = " + 3 * j);
            j -= 2;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfMultiples;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0093");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfMultiples = IO.readint("Informe a quantidade de multiplos de 3 impares: ");
            IO.println();
            
        } while(numberOfMultiples < 1);
        
        showSomeMultiplesOfThree(numberOfMultiples); // mostra multiplos de 3 impares
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
