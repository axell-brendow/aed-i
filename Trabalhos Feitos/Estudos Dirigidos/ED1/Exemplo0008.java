/*

PUC Minas - Ciência da Computação     Nome: Exemplo0008

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0008
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        boolean input = true;

        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0008");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        //mostra valor logico que ja esta armazenado na variavel
        IO.println("Valor logico contido na variavel: " + input);
        IO.println();

        // pega o valor logico do usuario
        input = IO.readboolean("Informe um novo valor logico: ");
        IO.println(); // pula uma linha

        // mostra valor logico informado
        IO.println("Valor logico informado: " + input);
        IO.println(); // pula uma linha

        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
