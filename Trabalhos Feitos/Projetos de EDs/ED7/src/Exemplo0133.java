/*

PUC Minas - Ciência da Computação     Nome: Exemplo0133

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 21/03/2018

*/

import IO.*;

public class Exemplo0133
{
    static String data = ""; // dados
    
    /**
     * Salva dados em arquivo
     */
    
    public static void saveData()
    {
        FILE file = new FILE(FILE.OUTPUT, "Exemplo0133.txt");
        
        file.println(data);
        
        file.close();
    }
    
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
            data += number + " ";
            
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
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0133");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de elementos da sequencia: ");
            IO.println();
            
        } while (numberOfValues < 1);
        
        showSequence(numberOfValues, 1);
        
        FILE file = new FILE(FILE.OUTPUT, "Exemplo0133.txt");
        
        file.println(data);
        
        file.close();
        
        IO.pause("Pressione ENTER para terminar");
    }
    
}
