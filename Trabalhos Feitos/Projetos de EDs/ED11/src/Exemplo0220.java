import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0220

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 11/04/2018

*/

public class Exemplo0220
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "fromFileMatrix.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0220");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        MatrixClass arr1 = new MatrixClass(5, 5);
        MatrixClass arr2 = new MatrixClass(5, 5);
        
        AxellIO.println("arr1 == arr2 = " + arr1.equals(arr2));
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}