/*

PUC Minas - Ciência da Computação     Nome: E1

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class E1
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        char input = 'A';
        int y = (int) input;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E1");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();
        
        //mostra caractere que ja esta armazenado na variavel
        IO.println("Caractere contido na variavel e sua representacao numerica: " + input + " (" + y + ")");
        IO.println();
        
        // pega o caractere do usuario
        input = IO.readchar("Informe um novo caractere: ");
        IO.println(); // pula uma linha
        
        y = (int) input;
        
        // mostra caractere informado
        IO.println("Caractere informado e sua representacao numerica: " + input + " (" + y + ")");
        IO.println(); // pula uma linha
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
