import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0231

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 11/04/2018

*/

public class Exemplo0231
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0231");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        Contato contato = new Contato();
        
        contato.readName(); // le um nome para o contato
        
        AxellIO.pause("Nome = " + contato.getName()); // mostra o nome
    }
    
}
