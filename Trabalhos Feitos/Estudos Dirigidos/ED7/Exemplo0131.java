/*

PUC Minas - Ciência da Computação     Nome: Exemplo0131

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 19/03/2018

*/

import IO.*;

public class Exemplo0131
{
    static String data = ""; // dados
    
    /**
     * Salva dados em arquivo
     */
    
    public static void saveData()
    {
        FILE file = new FILE(FILE.OUTPUT, "Exemplo0131.txt");
        
        file.println(data);
        
        file.close();
    }
    
    /**
     * Mostra certa quantidade de numeros impares em ordem decrescente ate o 5
     * @param numberOfValues quantidade de numeros impares a mostrar
     * @param number valor a mostrar
     */
    
    public static void showOddNumbers(int numberOfValues, int number)
    {
        // obviamente, so' mostra se a quantidade a mostrar for maior que 0
        if (numberOfValues > 0)
        {
            // rechama a funcao para que mostre o atual numero impar + 2
            showOddNumbers(numberOfValues - 1, number + 2);
            
            data += number + " ";
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfValues;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0131");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de valores impares: ");
            IO.println();
            
        } while (numberOfValues < 1);
        
        showOddNumbers(numberOfValues, 5);
        
        saveData();
        
        IO.pause("Pressione ENTER para terminar");
    }
    
}
