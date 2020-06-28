/*

PUC Minas - Ciência da Computação     Nome: Exemplo0097

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/03/2018

*/

import IO.*;

public class Exemplo0097
{
    /**
     * Checa o resto da divisao
     * @param numerator numerador da fracao
     * @param denominator denominador da fracao
     * @param desiredRest resto que se deseja encontrar
     * @return se resto e' o desejado ou nao
     */
    
    public static boolean checkRestOfDivision(int numerator, int denominator, int desiredRest)
    {
        return (Math.abs(numerator) % denominator == desiredRest);
    }
    
    /**
     * Obtem a soma de numeros personalizados
     * @param number numero de numeros personalizados
     * @return soma dos numeros personalizados
     */
    
    public static double getSum(int number)
    {
        double sum = 0;
        int multiple;
        int factor = 1; // o primeiro par nao multiplo de tres sera o 2 * 1
        
        for (int i = 0; i < number; i++) // percorre a quantidade de numeros a somar
        {
            if (checkRestOfDivision(factor, 3, 0)) // checa se o fator e' multiplo de 3
            {
                factor += 1; // pulo o fator que e' multiplo de 3
            }
            
            multiple = 2 * factor; // pega o inverso do par nao multiplo de 3
            
            sum += 1.0 / multiple; // soma-o aos outros
            
            // achei interessante ir mostrando os multiplos para que o usuario
            // possa conferir a soma deles
            IO.println((i + 1) + "o multiplo: 1/" + multiple);
            
            factor += 1; // aumenta o fator de multiplicacao
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
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0097");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfMultiples = IO.readint("Informe a quantidade de inversos dos pares nao multiplos de 3: ");
            IO.println();
            
        } while(numberOfMultiples < 1);
        
        IO.println("\nSoma: " + getSum(numberOfMultiples));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
