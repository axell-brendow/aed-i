/*

PUC Minas - Ciência da Computação     Nome: Exemplo0080

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/03/2018

*/

import IO.*;

public class Exemplo0080
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
    
    public static void showCharactersAndNumberOfCharacters(String digitsOnInterval, String presentToUser)
    {
        int numberOfDigitsOnInterval;
        
        numberOfDigitsOnInterval = digitsOnInterval.length();
        
        IO.println(presentToUser + numberOfDigitsOnInterval + " (" + digitsOnInterval + ")\n");
    }
    
    public static void showInformationOfDigitsOnInterval(String input)
    {
        String digitsOnInterval;
        
        //Pegar numeros
        digitsOnInterval = getDigitsOnInterval(input, '0', '9');
        
        //Mostrar a quantidade de numeros e os numeros
        showCharactersAndNumberOfCharacters(digitsOnInterval, "Quantidade de numeros: ");
        
        //Pegar as minusculas
        digitsOnInterval = getDigitsOnInterval(input, 'a', 'z');
        
        //Pegar e concatenar as maisculas
        digitsOnInterval += getDigitsOnInterval(input, 'A', 'Z');
        
        //Mostrar a quantidade de letras e as letras
        showCharactersAndNumberOfCharacters(digitsOnInterval, "Quantidade de letras: ");
    }
    
    public static void main(String[] args)
    {
        String input;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0080");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        //Pegando entrada do usuário
        input = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        //Mostrar caracteres e suas quantidades
        showInformationOfDigitsOnInterval(input);
        IO.println();
        
        IO.pause("Pressione ENTER para terminar");
    }
}
