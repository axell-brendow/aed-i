/*

PUC Minas - Ciência da Computação     Nome: Exemplo0007

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0007
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        double input = 43.21;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0007");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();
        
        //mostra valor real que ja esta armazenado na variavel
        IO.println("Valor real contido na variavel: " + input);
        IO.println();
        
        // pega o valor real do usuario
        input = IO.readdouble("Informe um novo valor real: ");
        IO.println(); // pula uma linha
        
        // mostra valor real informado
        IO.println("Valor real informado: " + input);
        IO.println(); // pula uma linha
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
