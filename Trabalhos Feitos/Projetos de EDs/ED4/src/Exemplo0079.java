/*

PUC Minas - Ciência da Computação     Nome: Exemplo0079

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/03/2018

*/

import IO.*;

public class Exemplo0079
{
    public static String getDigitsOnInterval(String input, char lowerLimit, char upperLimit)
    {
        
        String result="";
        char c;
        int length, number;
        
        length = input.length(); //tamanho da cadeia de caracteres
        
        for (int i = 0; i < length; i++) //percorrer cada caractere da cadeia
        {
            c = input.charAt(i);
            
            if (c >= lowerLimit && c <= upperLimit) //checando caractere no limite
            {
                number = c - 48; //convertendo o digito em numero inteiro
                
                //Obs.: O caractere '0' tem valor 48 na tabela ASCII
                
                if (number % 2 == 0) //checando numero par
                {
                    result += c; //concatenando os numeros pares
                }
            }
        }
        
        return result;
        
    }
    
    public static void showInformationOfDigitsOnInterval(String input, String presentToUser, char lowerLimit, char upperLimit)
    {
        String digitsOnInterval;
        
        digitsOnInterval = getDigitsOnInterval(input, lowerLimit, upperLimit);
        
        IO.println(presentToUser + digitsOnInterval);
    }
    
    public static void main(String[] args)
    {
        String input;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0079");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        //Pegando entrada do usuário
        input = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        //Mostrar numeros pares
        showInformationOfDigitsOnInterval(input, "Numeros pares: ", '0', '9');
        IO.println();
        
        IO.pause("Pressione ENTER para terminar");
    }
}
