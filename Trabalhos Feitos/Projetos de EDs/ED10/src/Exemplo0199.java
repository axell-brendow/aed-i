import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0199

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 09/04/2018

*/

public class Exemplo0199
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "toFileArray.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0199");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        ArrayClass arr = new ArrayClass(5);
        
        // le uma quantidade de elementos suficiente para preencher o arranjo da classe
        arr.readIntArray("Informe um inteiro: ");
        AxellIO.println();
        
        // pega o arranjo da classe invertido e o iguala ao arranjo da classe
        arr.array = arr.invertArray();
        
        arr.printArray(); // mostra todo o arranjo da classe
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}