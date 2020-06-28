import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0195

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 06/04/2018

*/

public class Exemplo0195
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "fromFileArray.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0195");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        ArrayClass arr = new ArrayClass(5);
        
        // pega os dois primeiros valores do arquivo e os grava no arranjo da classe
        arr.fromFile(fileName, 2);
        AxellIO.println();
        arr.printArray(); // mostra todo o arranjo da classe
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}