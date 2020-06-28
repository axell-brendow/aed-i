import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0235

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/04/2018

*/

public class Exemplo0235
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "toFileContato.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0235");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        Contato contato = new Contato("Theldo", "9999-9999");
        
        contato.toFile(fileName); // envia os dados do contato para um arquivo
        
        contato.fromFile(fileName); // le os dados do contato de um arquivo
        
        // mostra o nome e o telefone do contato
        AxellIO.println("Nome do contato: " + contato.getName() + "\nTelefone: " + contato.getPhone(0));
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}
