import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0238

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/04/2018

*/

public class Exemplo0238
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        // Obs.: Nao sei se foi um erro de digitacao ou nao, mas no pdf ed12,
        // no exercicio 8 esta' dizendo para criar um programa Exemplo0239 e nao
        // Exemplo0238, mas eu fiz aqui com o nome de Exemplo0238
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0238");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        // inicia o contato com um nome e um telefone
        Contato contato = new Contato("Theldo", "3333-3333");
        
        // coloca um segundo telefone na lista de telefones do contato
        contato.setPhone2("3737-7373");
        
        // mostra o segundo telefone
        AxellIO.pause("Telefone = " + contato.getPhone(1));
    }
    
}
