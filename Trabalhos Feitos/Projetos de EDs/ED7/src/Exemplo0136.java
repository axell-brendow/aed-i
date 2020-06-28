/*

PUC Minas - Ciência da Computação     Nome: Exemplo0136

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 21/03/2018

*/

import IO.*;

public class Exemplo0136
{
    static String data = ""; // dados
    
    /**
     * Salva dados em arquivo
     */
    
    public static void saveData()
    {
        FILE file = new FILE(FILE.OUTPUT, "Exemplo0136.txt");
        
        file.println(data);
        
        file.close();
    }
    
    /**
     * Obtem a soma de certa quantidade de numeros impares comecando do 3
     * @param numberOfValues quantidade de numeros impares a somar
     * @param number valor a somar a soma
     * @return soma da sequencia logica
     */
    
    public static int getSum(int numberOfValues, int number)
    {
        int sum = 0;
        
        // obviamente, so' somara' se a quantidade de elementos for maior que 0
        if (numberOfValues > 0)
        {
            // so' para acompanhar os numeros da sequencia logica
            data += number + " ";
            
            // soma o numero atual e tenta somar o proximo impar
            sum += number + getSum(numberOfValues - 1, number + 2);
        }
        
        return sum;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfValues, sum;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0136");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de valores impares: ");
            IO.println();
            
        } while (numberOfValues < 1);
        
        sum = getSum(numberOfValues, 3);
        
        data += "= " + sum;
        
        saveData();
        
        IO.pause("Pressione ENTER para terminar");
    }
    
}
