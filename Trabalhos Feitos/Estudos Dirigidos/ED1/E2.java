/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class E2
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        char x;
        int y = 97;
        
        x = (char) y;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();
        
        IO.println("Numero inteiro contido na variavel e sua representacao em caractere: " + y + " \'" + x + "\'");
        IO.println();
        
        y = IO.readint("Informe um novo numero inteiro: ");
        IO.println(); // pula uma linha
        
        x = (char) y;
        
        IO.println("Numero inteiro informado e sua representacao em caractere: " + y + " \'" + x + "\'");
        IO.println(); // pula uma linha
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
