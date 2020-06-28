import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0196

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 09/04/2018

*/

public class Exemplo0196
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "toFileArray.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0196");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        ArrayClass arr = new ArrayClass(5);
        
        // le uma quantidade de elementos suficiente para preencher o arranjo da classe
        arr.readIntArray("Informe um inteiro: ");
        AxellIO.println();
        
        arr.toFile(fileName, 2); // grava o arranjo da classe em arquivo
        arr.clearArray(); // apos gravar limpa o arranjo da classe
        
        arr.fromFile(fileName); // pega o arranjo do arquivo e o grava no arranjo da classe
        
        arr.printArray(); // mostra todo o arranjo da classe
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}