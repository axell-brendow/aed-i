import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 11/04/2018

*/

public class E2
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName1 = "TriangularSuperior.txt";
        String fileName2 = "NaoTriangular.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        MatrixClass arr = new MatrixClass(5, 5);
        
        arr.fromFile(fileName1);
        
        AxellIO.println(fileName1 + " e' triangular inferior" + " = " + arr.isSuperiorTriangular());
        
        arr.fromFile(fileName2);
        
        AxellIO.println(fileName2 + " e' triangular inferior" + " = " + arr.isSuperiorTriangular());
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}