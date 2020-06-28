/*

PUC Minas - Ciência da Computação     Nome: Exemplo0010

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0010
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String input;
        int y = 5;
        
        input = "" + y;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0010");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        //mostra a string que ja esta armazenada na variavel
        IO.println("Cadeia de caracteres contida na string: " + input);
        IO.println();

        // mostra numero inteiro definido
        IO.println("Numero inteiro contido na variavel do tipo int: " + y);
        IO.println(); // pula uma linha

        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
