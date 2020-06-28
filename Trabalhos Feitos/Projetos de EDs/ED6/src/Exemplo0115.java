/*

PUC Minas - Ciência da Computação     Nome: Exemplo0115

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 19/03/2018

*/

import IO.*;

public class Exemplo0115
{
    /**
     * Mostra caracteres de uma cadeia separadamente por linhas
     */
    
    public static void showCharacterOneByOne(String input, int index)
    {
        // checa se o indice e' valido
        if (index < input.length())
        {
            IO.println(input.charAt(index)); // mostra o caractere no indice rebecido
            
            showCharacterOneByOne(input, index + 1); // chama de novo somando 1 ao indice atual
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String input;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0115");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            input = IO.readString("Informe uma cadeia de caracteres: ");
            IO.println();
            
        } while (input.length() < 1);
        
        showCharacterOneByOne(input, 0);
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
