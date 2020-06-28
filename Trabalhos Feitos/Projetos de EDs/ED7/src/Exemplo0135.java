/*

PUC Minas - Ciência da Computação     Nome: Exemplo0135

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 21/03/2018

*/

import IO.*;

public class Exemplo0135
{
    static String data = ""; // dados
    
    /**
     * Salva dados em arquivo
     */
    
    public static void saveData()
    {
        FILE file = new FILE(FILE.OUTPUT, "Exemplo0135.txt");
        
        file.println(data);
        
        file.close();
    }
    
    /**
     * Mostra caracteres de uma cadeia separadamente por linhas
     * @param input cadeia de caracteres
     * @param index indice do caractere a se mostrar
     */
    
    public static void showCharacterOneByOne(String input, int index)
    {
        // checa se o indice e' valido
        if (index < input.length())
        {
            showCharacterOneByOne(input, index + 1); // chama de novo somando 1 ao indice atual
            
            data += input.charAt(index);
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String input;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0135");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            input = IO.readString("Informe uma cadeia de caracteres: ");
            IO.println();
            
        } while (input.length() < 1);
        
        showCharacterOneByOne(input, 0);
        
        saveData();
        
        IO.pause("Pressione ENTER para terminar");
    }
    
}
