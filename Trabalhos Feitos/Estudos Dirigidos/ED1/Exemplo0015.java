/*

PUC Minas - Ciência da Computação     Nome: Exemplo0015

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0015
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        double x, y;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0015");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        x = IO.readdouble("Informe um valor real: ");
        IO.println();
        
        IO.println("Valor informado: " + x);
        IO.println();
        
        y = IO.readdouble("Informe outro valor real: ");
        IO.println();
        
        IO.println("Valor informado: " + y);
        IO.println();
        
        IO.println("Soma dos valores: " + (x + y));
        IO.println();
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
