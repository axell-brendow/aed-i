/*

PUC Minas - Ciência da Computação     Nome: Exemplo0092

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/03/2018

*/

import IO.*;

public class Exemplo0092
{    
    /**
     * Mostra multiplos de 3 que sao pares em ordem crescente comecando do 0
     * @param number Quantidade de multiplos a mostrar
     */
    
    public static void showSomeMultiplesOfThree(int number)
    {
        int j = 0; // fator de multiplicacao
        
        // percorre a quantidade de multiplos a mostrar
        for (int i = 0; i < number; i++)
        {
            IO.println("3 x " + j + " = " + 3 * j);
            j += 2;
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfMultiples;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0092");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfMultiples = IO.readint("Informe a quantidade de multiplos de 3 pares: ");
            IO.println();
            
        } while(numberOfMultiples < 1);
        
        showSomeMultiplesOfThree(numberOfMultiples); // mostra multiplos de 3 pares
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
