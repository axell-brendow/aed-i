/*

PUC Minas - Ciência da Computação     Nome: Exemplo0113

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 19/03/2018

*/

import IO.*;

public class Exemplo0113
{
    /**
     * Mostra certa quantidade de numeros de uma sequencia logica
     * @param numberOfValues quantidade de numeros a mostrar
     * @param number valor a mostrar
     */
    
    public static void showSequence(int numberOfValues, int number)
    {
        // obviamente, so' mostra se a quantidade a mostrar for maior que 0
        if (numberOfValues > 0)
        {
            IO.print(number + " "); // mostra o numero
            
            // se o atual valor for 1, o primeiro valor da sequencia, soma 4, caso nao, soma 5
            int nextNumber = number == 1 ? number + 4 : number + 5; // proximo valor da sequencia
            
            showSequence(numberOfValues - 1, nextNumber);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfValues;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0113");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de elementos da sequencia: ");
            IO.println();
            
        } while (numberOfValues < 1);
        
        showSequence(numberOfValues, 1);
        
        IO.pause("\n\nPressione ENTER para terminar");
    }
    
}
