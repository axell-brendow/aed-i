import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0211

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/04/2018

*/

public class Exemplo0211
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0211");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        MatrixClass arr = new MatrixClass(5, 5);
        
        arr.readIntMatrix("Informe um inteiro: ", 4, 1, 4, 1);
        AxellIO.println();
        arr.printMatrix();
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}