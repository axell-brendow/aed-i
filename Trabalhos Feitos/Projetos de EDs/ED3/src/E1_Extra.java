/*

Exercício Extra 1 - Estudo Dirigido 3

Matricula: 631822            Nome: Axell Brendow Batista Moreira
Versao:  1.0                 Data: 04/03/2018

*/

import IO.*;

public class E1_Extra
{
    public static boolean isNumber(char c)
    {
        if (c >= '0' && c <= '9')
        {
            return true;
        }
        
        return false;
    }
    
    public static boolean isLetter(char c)
    {
        if ( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') )
        {
            return true;
        }
        
        return false;
    }
    
    public static String getAlphaNumericDigits(String input)
    {
        String result="";
        char c;
        int length;
        
        length = input.length();
        
        for (int i = 0; i < length; i++)
        {
            c = input.charAt(i);
            
            if (isNumber(c) || isLetter(c))
            {
                result += c + " ";
            }
        }
        
        return result;
    }
    
    public static void main (String[] args)
    {
        
        String input, result;
        
        input = IO.readString("Entre com uma cadeia de caracteres: ");
        
        result = getAlphaNumericDigits(input);
        
        IO.println(result);
        
    }
}
