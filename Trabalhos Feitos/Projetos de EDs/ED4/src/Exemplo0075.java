/*

PUC Minas - Ciência da Computação     Nome: Exemplo0075

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/03/2018

*/

import IO.*;

public class Exemplo0075
{
    public static String getDigitsOnInterval(String input, char lowerLimit, char upperLimit)
    {
        
        String result="";
        char c;
        int length;
        
        length = input.length(); //tamanho da cadeia de caracteres
        
        for (int i = 0; i < length; i++) //percorrer cada caractere da cadeia
        {
            c = input.charAt(i);
            
            if (c >= lowerLimit && c <= upperLimit) //checando caractere no limite
            {
                result += c; //concatenando os caracteres que estao dentro do limite
            }
        }
        
        return result;
        
    }
    
    public static int getNumberOfDigitsOnInterval(String input, char lowerLimit, char upperLimit)
    {
        int numberOfDigitsOnInterval;
        
        numberOfDigitsOnInterval = getDigitsOnInterval(input, lowerLimit, upperLimit).length();
        
        return numberOfDigitsOnInterval;
    }
    
    public static void showInformationOfDigitsOnInterval(String input, String presentToUser, char lowerLimit, char upperLimit)
    {
        int numberOfDigitsOnInterval;
        
        numberOfDigitsOnInterval = getNumberOfDigitsOnInterval(input, lowerLimit, upperLimit);
        
        IO.println(presentToUser + numberOfDigitsOnInterval);
    }
    
    public static void main(String[] args)
    {
        String input;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0075");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        //Pegando entrada do usuário
        input = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        //Mostrar numero de minusculas
        showInformationOfDigitsOnInterval(input, "Numero de minusculas: ", 'a', 'z');
        
        //Mostrar numero de maiusculas
        showInformationOfDigitsOnInterval(input, "Numero de maiusculas: ", 'A', 'Z');
        IO.println();
        
        IO.pause("Pressione ENTER para terminar");
    }
}
