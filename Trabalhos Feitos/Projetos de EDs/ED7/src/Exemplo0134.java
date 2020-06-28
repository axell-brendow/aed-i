/*

PUC Minas - Ciência da Computação     Nome: Exemplo0134

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 21/03/2018

*/

import IO.*;

public class Exemplo0134
{
    static String data = ""; // dados
    
    /**
     * Salva dados em arquivo
     */
    
    public static void saveData()
    {
        FILE file = new FILE(FILE.OUTPUT, "Exemplo0134.txt");
        
        file.println(data);
        
        file.close();
    }
    
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
            
            data += "1/" + respectivePotence + " ";
            
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
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0134");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de elementos da sequencia: ");
            IO.println();
            
        } while (numberOfValues < 1);
        
        showSequence(numberOfValues);
        
        saveData();
        
        IO.pause("Pressione ENTER para terminar");
    }
    
}
