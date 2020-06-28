/*

PUC Minas - Ciência da Computação     Nome: Exemplo0013

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0013
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int x, y;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0013");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        x = IO.readint("Informe um valor inteiro: ");
        IO.println();
        
        IO.println("Valor informado: " + x);
        IO.println();
        
        y = IO.readint("Informe outro valor inteiro: ");
        IO.println();
        
        IO.println("Valor informado: " + y);
        IO.println();
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
