/*

PUC Minas - Ciência da Computação     Nome: Exemplo0091

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/03/2018

*/

import IO.*;

public class Exemplo0091
{
    /**
     * Mostra multiplos de 3 em ordem crescente comecando do 0
     * @param number Quantidade de multiplos a mostrar
     */
    
    public static void showSomeMultiplesOfThree(int number)
    {
        // percorre a quantidade de multiplos a mostrar
        for (int i = 0; i < number; i++)
        {
            IO.println("3 x " + i + " = " + 3 * i);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfMultiples;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0091");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfMultiples = IO.readint("Informe a quantidade de multiplos de 3: ");
            IO.println();
            
        } while(numberOfMultiples < 1);
        
        showSomeMultiplesOfThree(numberOfMultiples);
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
