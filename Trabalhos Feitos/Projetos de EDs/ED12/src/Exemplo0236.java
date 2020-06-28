import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0236

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/04/2018

*/

public class Exemplo0236
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "toFileContato.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0236");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        // novo construtor com 2 telefones
        Contato contato = new Contato("Theldo", "9999-9999", "8888-8888");
        
        contato.toFile(fileName); // envia os dados do contato para um arquivo
        
        contato.fromFile(fileName); // recupera os dados do arquivo
        
        // mostra o nome do contato e indica o inicio da lista de telefones
        AxellIO.println("Nome do contato: " + contato.getName() + "\nTelefones:");
        
        for (int i = 0; i < 2; i++)
        {
            AxellIO.println(contato.getPhone(i)); // mostra os dois telefones
        }
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}
