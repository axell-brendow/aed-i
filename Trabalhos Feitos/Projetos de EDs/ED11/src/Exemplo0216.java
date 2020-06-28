import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0216

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 10/04/2018

*/

public class Exemplo0216
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "toFileMatrix.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0216");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        MatrixClass arr = new MatrixClass(3, 3);
        
        // le uma quantidade de elementos suficiente para preencher a matriz da classe
        arr.readIntMatrix("Informe um inteiro: ");
        AxellIO.println();
        
        arr.toFile(fileName, 2, 2);
        arr.clearMatrix(); // apos gravar limpa a matriz da classe
        
        arr.fromFile(fileName); // pega a matriz do arquivo e a grava na matriz da classe
        
        arr.printMatrix(); // mostra toda a matriz da classe
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}