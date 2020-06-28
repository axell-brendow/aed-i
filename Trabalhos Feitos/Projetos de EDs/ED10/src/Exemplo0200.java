import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0200

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 09/04/2018

*/

public class Exemplo0200
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "toFileArray.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0200");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        ArrayClass arr = new ArrayClass(5);
        
        // le uma quantidade de elementos suficiente para preencher o arranjo da classe
        arr.readIntArray("Informe um inteiro: ");
        AxellIO.println();
        
        // a partir do indice 2, pega dois elementos do arranjo da classe
        // e iguala esse novo arranjo ao arranjo da classe
        arr.array = arr.copyArray(2, 2);
        
        arr.printArray(); // mostra todo o arranjo da classe
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}