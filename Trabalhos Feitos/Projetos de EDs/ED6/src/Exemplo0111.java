/*

PUC Minas - Ciência da Computação     Nome: Exemplo0111

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 19/03/2018

*/

import IO.*;

public class Exemplo0111
{
    /**
     * Mostra certa quantidade de numeros impares comecando do 5
     * @param numberOfValues quantidade de numeros impares a mostrar
     * @param number valor a mostrar
     */
    
    public static void showOddNumbers(int numberOfValues, int number)
    {
        // obviamente, so' mostra se a quantidade a mostrar for maior que 0
        if (numberOfValues > 0)
        {
            IO.print(number + " "); // mostra o numero
            
            // rechama a funcao para que mostre o atual numero impar + 2
            showOddNumbers(numberOfValues - 1, number + 2);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfValues;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0111");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de valores impares: ");
            IO.println();
            
        } while (numberOfValues < 1);
        
        // mostra uma quantidade de impares comecando do 5
        showOddNumbers(numberOfValues, 5);
        
        IO.pause("\n\nPressione ENTER para terminar");
    }
    
}
