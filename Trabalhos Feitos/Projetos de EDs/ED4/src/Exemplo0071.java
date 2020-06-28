/*

PUC Minas - Ciência da Computação     Nome: Exemplo0071

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/03/2018

*/

import IO.*;

public class Exemplo0071
{
    
    public static void showLowerCases(String input)
    {
        
        String lowerCases="";
        char c;
        int length;
        
        length = input.length(); //tamanho da cadeia de caracteres
        
        for (int i = 0; i < length; i++) //percorrer cada caractere da cadeia
        {
            c = input.charAt(i);
            
            if (c >= 'a' && c <= 'z') //checando o limite
            {
                lowerCases += c; //concatenando os caracteres que estao dentro do limite
            }
        }
        
        IO.println("Minusculas: " + lowerCases + "\n");
        
    }
    
    public static void main(String[] args)
    {
        String input;
        
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0071");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        input = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        showLowerCases(input);
        
        IO.pause("Pressione ENTER para terminar");
    }
}
