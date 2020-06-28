/*

PUC Minas - Ciência da Computação     Nome: Exemplo0132

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 20/03/2018

*/

import IO.*;

public class Exemplo0132
{
    static String data = ""; // dados
    
    /**
     * Salva dados em arquivo
     */
    
    public static void saveData()
    {
        FILE file = new FILE(FILE.OUTPUT, "Exemplo0132.txt");
        
        file.println(data);
        
        file.close();
    }
    
    /**
     * Mostra multiplos de 5 em ordem crescente comecando do 5
     * @param numberOfValues quantidade de multiplos a mostrar
     */
    
    public static void showMultiplesOfFive(int numberOfValues)
    {
        // obviamente, so' mostra se a quantidade a mostrar for maior que 0
        if (numberOfValues > 0)
        {
            showMultiplesOfFive(numberOfValues - 1);
            
            data += 5 * numberOfValues + " ";
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfValues;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0132");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de multiplos de 5: ");
            IO.println();
            
        } while (numberOfValues < 1);
        
        showMultiplesOfFive(numberOfValues);
        
        saveData();
        
        IO.pause("Pressione ENTER para terminar");
    }
    
}
