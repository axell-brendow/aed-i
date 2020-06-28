/*

PUC Minas - Ciência da Computação     Nome: Exemplo0012

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0012
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String input;
        int y = 5;
        double z = 0.4;
        boolean w;
        
        w = y > z;
        input = "" + w;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0012");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        //mostra a string que ja esta armazenada na variavel
        IO.println("Cadeia de caracteres contida na string: " + input);
        IO.println();

        // mostra numero inteiro definido
        IO.println("Numero inteiro contido na variavel do tipo int: " + y);
        IO.println(); // pula uma linha
        
        // mostra numero real definido
        IO.println("Numero real contido na variavel do tipo double: " + z);
        IO.println(); // pula uma linha
        
        // mostra valor logico obtido
        IO.println("Valor logico contido na variavel do tipo boolean: " + w);
        IO.println(); // pula uma linha
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
