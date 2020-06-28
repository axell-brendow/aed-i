/*

PUC Minas - Ciência da Computação     Nome: Exemplo0112

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 19/03/2018

*/

import IO.*;

public class Exemplo0112
{
    /**
     * Mostra multiplos de 5 em ordem decrescente ate chegar no 5
     * @param numberOfValues quantidade de multiplos a mostrar
     */
    
    public static void showMultiplesOfFive(int numberOfValues)
    {
        // obviamente, so' mostra se a quantidade a mostrar for maior que 0
        if (numberOfValues > 0)
        {
            IO.print(5 * numberOfValues + " ");
            
            showMultiplesOfFive(numberOfValues - 1);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfValues;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0112");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de multiplos de 5: ");
            IO.println();
            
        } while (numberOfValues < 1);
        
        showMultiplesOfFive(numberOfValues);
        
        IO.pause("\n\nPressione ENTER para terminar");
    }
    
}
