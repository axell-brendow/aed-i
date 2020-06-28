import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0239

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/04/2018

*/

public class Exemplo0239
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        // Obs.: Nao sei se foi um erro de digitacao ou nao, mas no pdf ed12,
        // no exercicio 9 esta' dizendo para criar um programa Exemplo0238 e nao
        // Exemplo0239, mas eu fiz aqui com o nome de Exemplo0239
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0239");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        // inicia o contato com um nome e um telefone
        Contato contato = new Contato("Theldo", "3333-3333", "3637-4031");
        
        // coloca um segundo telefone na lista de telefones do contato
        contato.changePhone2("3737-7373");
        
        // mostra o segundo telefone
        AxellIO.pause("Telefone = " + contato.getPhone(1));
    }
    
}
