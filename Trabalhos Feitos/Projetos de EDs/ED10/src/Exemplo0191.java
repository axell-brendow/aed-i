import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: Exemplo0191

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 04/04/2018

*/

public class Exemplo0191
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0191");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        ArrayClass arr = new ArrayClass(5);
        
        // le 1 elemento e o grava no indice 4 do arranjo da classe
        arr.readIntArray("Informe um inteiro: ", 4, 1);
        AxellIO.println();
        arr.printArray(); // mostra todo o arranjo da classe
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}