import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/04/2018

*/

public class E2
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "fromFileContatoE2.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        Contato contato = new Contato();
        
        // Le as informacoes do contato de arquivo
        contato.fromFile(fileName);
        
        // mostra o nome do contato
        AxellIO.println("Nome: " + contato.getName());
        
        // mostra o endereco residencial
        AxellIO.println("Endereco residencial: " + contato.getResidentialAddress());
        
        // mostra o endereco profissional
        AxellIO.println("Endereco profissional: " + contato.getProfessionalAddress());
        
        // indica o inicio da lista de telefones
        AxellIO.println("\nTelefones:");
        
        // percorre a quantidade de telefones que o contato tiver
        for (int i = 0; i < contato.getNumberOfPhones(); i++)
        {
            // mostra cada um deles
            AxellIO.println(contato.getPhone(i));
        }
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}
