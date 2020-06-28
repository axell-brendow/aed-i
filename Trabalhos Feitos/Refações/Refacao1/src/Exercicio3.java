/*

PUC Minas - Ciencia da Computacao     Nome: Exercicio3

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 09/04/2018

*/

import IO.*;

public class Exercicio3
{
    
    public static int getNumberOfLowerVogals(String str)
    {
        int numberOfLowerVogals = 0;
        boolean isLowerVogal;
        
        char[] lowerVogals = { 'a', 'e', 'i', 'o', 'u' };
        
        for (int i = 0; i < str.length(); i++)
        {
            isLowerVogal = false;
            
            for (char vogal : lowerVogals)
            {
                isLowerVogal = isLowerVogal == true ? true : vogal == str.charAt(i);
            }
            
            numberOfLowerVogals += isLowerVogal ? 1 : 0;
        }
        
        return numberOfLowerVogals;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exercicio3");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        String input = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        IO.println("Quantidade de vogais minusculas: " + getNumberOfLowerVogals(input));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
