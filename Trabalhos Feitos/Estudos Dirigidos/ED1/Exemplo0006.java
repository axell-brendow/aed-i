/*

PUC Minas - Ciência da Computação     Nome: Exemplo0006

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0006
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        char input = 'A';
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0006");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();
        
        //mostra caractere que ja esta armazenado na variavel
        IO.println("Caractere contido na variavel: " + input);
        IO.println();
        
        // pega o caractere do usuario
        input = IO.readchar("Informe um novo caractere: ");
        IO.println(); // pula uma linha
        
        // mostra caractere informado
        IO.println("Caractere informado: " + input);
        IO.println(); // pula uma linha
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
