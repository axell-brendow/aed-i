/*

PUC Minas - Ciência da Computação     Nome: Exemplo0020

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0020
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        double x, y;
        int a, b;
        String z;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0020");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        x = IO.readdouble("Informe um valor real: ");
        IO.println();
        
        a = IO.readint("Informe uma valor inteiro: ");
        IO.println();
        
        z = IO.readString("Informe uma sequencia de digitos: ");
        IO.println();
        
        y = IO.getdouble(z); // obtem um valor real dos digitos
        
        z = IO.readString("Informe uma sequencia de digitos: ");
        IO.println();
        
        b = IO.getint(z); // obtem um valor inteiro dos digitos
        
        z = "(" + x + ", " + a + ")";
        z = z + "(" + y + ", " + b + ")";
        
        IO.println("Concatenacao dos pares: " + z);
        IO.println();
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
