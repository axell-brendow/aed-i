import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0214

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/04/2018

*/

public class Exemplo0214
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "toFileMatrix.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0214");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        MatrixClass arr = new MatrixClass(3, 3);
        
        // le uma quantidade de elementos suficiente para preencher a matriz da classe
        arr.readIntMatrix("Informe um inteiro: ");
        AxellIO.println();
        
        arr.toFile(fileName); // grava a matriz da classe em arquivo
        arr.fromFile(fileName); // pega a mesma matriz do arquivo e o grava na matriz da classe
        
        arr.printMatrix(); // mostra toda a matriz da classe
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}