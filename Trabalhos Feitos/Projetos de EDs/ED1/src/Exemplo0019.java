/*

PUC Minas - Ciência da Computação     Nome: Exemplo0019

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0019
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String x, y;
        int a, b;
        String z;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0019");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        x = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        a = IO.readint("Informe uma valor inteiro: ");
        IO.println();
        
        x += a;
        
        y = IO.readString("Informe outra cadeia de caracteres: ");
        IO.println();
        
        z = IO.readString("Informe uma sequencia de digitos: ");
        IO.println();
        
        b = IO.getint(z);
        
        y += "" + b;
        
        IO.println("Primeira cadeia concatenada: " + x);
        IO.println("Segunda cadeia concatenada: " + y);
        IO.println();
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
