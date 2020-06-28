import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0217

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/04/2018

*/

public class Exemplo0217
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "fromFileMatrix.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0217");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        MatrixClass arr = new MatrixClass(5, 5);
        
        arr.fromFile(fileName, 4, 1, 4, 1);
        
        arr.printMatrix(); // mostra toda a matriz da classe
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}