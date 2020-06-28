/*

PUC Minas - Ciência da Computação     Nome: Exemplo0018

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0018
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String x, y;
        String z;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0018");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        x = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        y = IO.readString("Informe outra cadeia de caracteres: ");
        IO.println();
        
        z = x + "|" + y;
        
        IO.println("Cadeias concatenadas: " + z);
        IO.println();
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
