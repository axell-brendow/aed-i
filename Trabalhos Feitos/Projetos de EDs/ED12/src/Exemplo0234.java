import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0234

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/04/2018

*/

public class Exemplo0234
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "fromFileContato.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0234");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        Contato contato = new Contato();
        
        contato.fromFile(fileName); // pega os dados do contato de um arquivo
        
        // mostra o nome do contato e o telefone
        AxellIO.println("Nome do contato: " + contato.getName() + "\nTelefone: " + contato.getPhone(0));
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}
