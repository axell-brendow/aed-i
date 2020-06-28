/*

PUC Minas - Ciência da Computação     Nome: Exemplo0073

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/03/2018

*/

import IO.*;

public class Exemplo0073
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
            
            if (c >= lowerLimit && c <= upperLimit) //checando o limite
            {
                result += c; //concatenando os caracteres que estao dentro do limite
            }
        }
        
        return result;
        
    }
    
    public static int getNumberOfLowerCases(String input)
    {
        int numberOfLowerCases;
        
        numberOfLowerCases = getDigitsOnInterval(input, 'a', 'z').length();
        
        return numberOfLowerCases;
    }
    
    public static void showNumberOfLowerCases(String input)
    {
        int numberOfLowerCases;
        
        numberOfLowerCases = getNumberOfLowerCases(input);
        
        IO.println("Numero de minusculas: " + numberOfLowerCases + "\n");
    }
    
    public static void main(String[] args)
    {
        String input;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0073");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        //Pegando entrada do usuário
        input = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        //Mostrar numero de minusculas
        showNumberOfLowerCases(input);
        
        IO.pause("Pressione ENTER para terminar");
    }
}
