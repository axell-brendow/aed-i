/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/03/2018

*/

import IO.*;

public class E2
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
    
    public static String getDigitsOutOfInterval(String input, char intervals[])
    {
        
        int intervalsLength = intervals.length;
        boolean isOnInterval;
        String result="";
        int length;
        char c;
        
        length = input.length(); //tamanho da cadeia de caracteres
        
        for (int i = 0; i < length; i++) //percorrer cada caractere da cadeia
        {
            c = input.charAt(i);
            isOnInterval = false;
            
            //percorrer cada intervalo e checar se o caractere esta em algum
            for (int interval = 0; interval < intervalsLength; interval += 2)
            {
                //checando caractere dentro do intervalo
                if (c >= intervals[interval] && c <= intervals[interval + 1])
                {
                    isOnInterval = true;
                    break;
                }
            }
            
            if (!isOnInterval)
            {
                result += c; //concatenando os caracteres que estao fora do intervalo
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
    
    public static void showInformationOfDigitsOnInterval(String input, int index, int size)
    {
        String digitsOnInterval, pieceOfString;
        
        //Pegar o pedaco de String a ser analisado
        input = input.substring(index, index + size);
        
        //Intervalos dos caracteres alfanumericos
        char intervals[] = new char[]{'0', '9', 'a', 'z', 'A', 'Z'};
        
        //Pegar numeros
        digitsOnInterval = getDigitsOnInterval(input, intervals[0], intervals[1]);
        
        //Mostrar a quantidade de numeros e os numeros
        showCharactersAndNumberOfCharacters(digitsOnInterval, "Quantidade de numeros: ");
        
        //Pegar as minusculas
        digitsOnInterval = getDigitsOnInterval(input, intervals[2], intervals[3]);
        
        //Pegar e concatenar as maisculas
        digitsOnInterval += getDigitsOnInterval(input, intervals[4], intervals[5]);
        
        //Mostrar a quantidade de letras e as letras
        showCharactersAndNumberOfCharacters(digitsOnInterval, "Quantidade de letras: ");
        
        //Pegar caracteres fora do intervalo dos alfanumericos
        digitsOnInterval = getDigitsOutOfInterval(input, intervals);
        
        //Mostrar os caracteres nao alfanumericos e a quantidade deles
        showCharactersAndNumberOfCharacters(digitsOnInterval, "Quantidade de caracteres nao alfanumericos: ");
    }
    
    public static void main(String[] args)
    {
        String input;
        int index = -1;
        int size = -1;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        //Pegando entrada do usuário
        input = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        //Esperar um indice entre 0 e (tamanho da cadeia - 1)
        while (index < 0 || index > input.length() - 1)
        {
            //Pegando o indice de comeco do pedaco de String
            index = IO.readint("Comecando do 0, informe o indice de comeco que deseja: ");
            IO.println();
        }
        
        //Esperar um tamanho entre 1 e o tamanho da cadeia
        while (size < 1 || size > input.length())
        {
            //Pegando o tamanho do pedaco de String
            size = IO.readint("Informe o tamanho do pedaco que deseja: ");
            IO.println();
        }
        
        //Mostrar caracteres e suas quantidades
        showInformationOfDigitsOnInterval(input, index, size);
        IO.println();
        
        IO.pause("Pressione ENTER para terminar");
    }
}
