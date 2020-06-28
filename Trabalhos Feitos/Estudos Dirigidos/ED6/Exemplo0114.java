/*

PUC Minas - Ciência da Computação     Nome: Exemplo0114

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 19/03/2018

*/

import IO.*;

public class Exemplo0114
{
    /**
     * Mostra certa quantidade de numeros de uma sequencia logica
     * @param numberOfValues quantidade de numeros a mostrar
     */
    
    public static void showSequence(int numberOfValues)
    {
        // obviamente, so' mostra se a quantidade a mostrar for maior que 0
        if (numberOfValues > 0)
        {
            // pega o denominador da fracao
            int respectivePotence = (int) Math.pow(5, numberOfValues - 1);
            
            IO.print("1/" + respectivePotence + " "); // mostra a fracao
            
            showSequence(numberOfValues - 1);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfValues;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0114");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de elementos da sequencia: ");
            IO.println();
            
        } while (numberOfValues < 1);
        
        showSequence(numberOfValues);
        
        IO.pause("\n\nPressione ENTER para terminar");
    }
    
}
