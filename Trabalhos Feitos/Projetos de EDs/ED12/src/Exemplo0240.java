import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0240

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/04/2018

*/

public class Exemplo0240
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0240");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        // inicia o contato com nome e dois telefones
        Contato contato = new Contato("Theldo", "3333-3333", "3737-7373");
        
        contato.removePhone2(); // remove o segundo telefone
        
        // tenta mostrar o segundo telefone
        AxellIO.pause("Telefone = " + contato.getPhone(1));
    }
    
}
