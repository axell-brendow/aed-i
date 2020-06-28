/*

PUC Minas - Ciência da Computação     Nome: Exemplo0009

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0009
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String input = "43.21";

        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0009");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        //mostra a string que ja esta armazenada na variavel
        IO.println("Cadeia de caracteres contida na variavel: " + input);
        IO.println();

        // pega a string do usuario
        input = IO.readString("Informe uma nova cadeia de caracteres: ");
        IO.println(); // pula uma linha

        // mostra a string informada
        IO.println("Cadeia de caracteres informada: " + input);
        IO.println(); // pula uma linha

        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
