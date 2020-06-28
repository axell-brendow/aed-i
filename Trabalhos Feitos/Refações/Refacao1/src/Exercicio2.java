/*

PUC Minas - Ciencia da Computacao     Nome: Exercicio2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 09/04/2018

*/

import IO.*;

public class Exercicio2
{
    
    public static int getNumberOfDivisors(int number)
    {
        int numberOfDivisors = 0;
        int absNumber = Math.abs(number);
        
        for (int i = absNumber / 2; i > 1; i--)
        {
            if (absNumber % i == 0)
            {
                numberOfDivisors++;
            }
        }
        
        return numberOfDivisors;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int int1, int2, nDivs1, nDivs2;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exercicio2");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        int1 = IO.readint("Informe um inteiro: ");
        int2 = IO.readint("Informe um inteiro: ");
        IO.println();
        
        nDivs1 = getNumberOfDivisors(int1);
        nDivs2 = getNumberOfDivisors(int2);
        
        IO.print("Tirando o proprio numero e o 1, ");
        
        if (nDivs1 == nDivs2)
        {
            IO.println("ambos tem a mesma quantidade de divisores positivos");
        }
        
        else if (nDivs1 > nDivs2)
        {
            IO.println(int1 + " tem mais divisores positivos");
        }
        
        else
        {
            IO.println(int2 + " tem mais divisores positivos");
        }
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
