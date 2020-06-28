import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0232

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/04/2018

*/

public class Exemplo0232
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0232");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        Contato contato = new Contato();
        
        contato.readPhone(); // le um telefone para o contato
        
        AxellIO.pause("Telefone = " + contato.getPhone(0)); // mostra o telefone
    }
    
}
