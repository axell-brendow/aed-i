/*

PUC Minas - Ciência da Computação     Nome: Exemplo0017

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

import IO.*;

public class Exemplo0017
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        char x, y;
        String z;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0017");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        IO.println();

        x = IO.readchar("Informe um caractere: ");
        IO.println();
        
        z = IO.readString("Informe uma cadeia de caracteres: ");
        IO.println();
        
        y = IO.getchar(z); // pega o primeiro caractere de z
        
        /*
        Como o enunciado do exercicio ficou confuso pra mim, nao sei
        se fiz exatamente o que ele pede. Entendi que ao extrair x e y
        deveria concatenar esses valores a propria cadeia de caracteres z
        */
        z = z + x + y;
        
        IO.println("Nova cadeia de caracteres: " + z);
        IO.println();
        
        IO.pause("Pressione ENTER para terminar"); // pausa a execucao
    }
    
}
