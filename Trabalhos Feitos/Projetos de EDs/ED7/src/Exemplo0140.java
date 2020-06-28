/*

PUC Minas - Ciência da Computação     Nome: Exemplo0140

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 21/03/2018

*/

import IO.*;

public class Exemplo0140
{
    static String data = ""; // dados
    
    /**
     * Salva dados em arquivo
     */
    
    public static void saveData()
    {
        FILE file = new FILE(FILE.OUTPUT, "Exemplo0140.txt");
        
        file.println(data);
        
        file.close();
    }
    
    /**
     * Checa se um caractere esta num intervalo de simbolos
     * @param character caractere a analisar
     * @param lowerLimit limite inferior do intervalo
     * @param upperLimit limite superior do intervalo
     * @return valor logico da proposicao da funcao
     */
    
    public static boolean isCharacterOnInterval(char character, char lowerLimit, char upperLimit)
    {
        return character >= lowerLimit && character <= upperLimit;
    }
    
    /**
     * Percorre uma cadeia de caracteres somando a quantidade de maiusculas
     * @param input cadeia de caracteres a ser analisada
     * @param index indice de comeco
     * @return quantidade de maiusculas
     */
    
    public static int getNumberOfDigits(String input, int index)
    {
        int numberOfDigits = 0;
        
        if (index < input.length()) // sera' valido ate o ultimo caractere
        {
            if (isCharacterOnInterval(input.charAt(index), '0', '9'))
            {
                numberOfDigits++;
                data += input.charAt(index) + " ";
            }
            
            numberOfDigits += getNumberOfDigits(input, index + 1);
        }
        
        return numberOfDigits;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String input;
        int numberOfDigits;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0140");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            input = IO.readString("Informe uma cadeia de caracteres: ");
            IO.println();
            
        } while (input.length() < 1);
        
        numberOfDigits = getNumberOfDigits(input, 0);
        
        data += "-> Numero de digitos: " + numberOfDigits;
        
        saveData();
        
        IO.pause("Pressione ENTER para terminar");
    }
    
}
