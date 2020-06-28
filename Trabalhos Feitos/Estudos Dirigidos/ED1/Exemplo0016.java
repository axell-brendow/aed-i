/*

PUC Minas - Ciência da Computação     Nome: Exemplo0016

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0016
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        char x, y;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0016");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        x = IO.readchar("Informe um caractere: ");
        IO.println();
        
        y = IO.readchar("Informe outro caractere: ");
        IO.println();
        
        IO.println("Caracteres informados: " + x + y);
        IO.println();
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
