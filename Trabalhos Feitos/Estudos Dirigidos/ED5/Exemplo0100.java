/*

PUC Minas - Ciência da Computação     Nome: Exemplo0100

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/03/2018

*/

import IO.*;

public class Exemplo0100
{
    /**
     * Obtem a soma de numeros personalizados
     * @param number numero de numeros personalizados
     * @return soma dos numeros personalizados
     */
    
    public static double getSum(int number)
    {
        double sum = 0;
        int currentNumber;
        
        for (int i = 0; i < number; i++) // percorre a quantidade de numeros a somar
        {
            currentNumber = i + 1;
            
            // achei interessante ir mostrando os numeros para que o usuario
            // possa conferir a soma deles
            IO.println("1/" + currentNumber);
            
            sum += 1.0/currentNumber;
        }
        
        return sum;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfMultiples;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0100");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfMultiples = IO.readint("Informe a quantidade de numeros naturais: ");
            IO.println();
            
        } while(numberOfMultiples < 1);
        
        IO.println("\nSoma: " + getSum(numberOfMultiples));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
