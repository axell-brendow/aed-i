import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0233

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/04/2018

*/

public class Exemplo0233
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0233");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        // construtor com nome e telefone, porém o telefone e' invalido.
        Contato contato = new Contato("Theldo", "33");
    }
    
}
