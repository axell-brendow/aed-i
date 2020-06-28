/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 02/04/2018

*/

import java.io.IOException;
import IO.*;

public class E2
{
    /**
     * Cria um arranjo bidimensional de acordo com os dados do usuario
     * @return arranjo bidimensional informado pelo usuario
     */
    
    public static double[][] create2DArray() throws IOException
    {
        double array[][];
        int lines, columns, element = 1;
        
        do
        {
            lines = AxellIO.readint("Informe o numero de linhas da matriz: ");
            AxellIO.println();
            
        } while (lines < 1 || lines > 10); // aceita quantidade do intervalo [1, 10]
        
        do
        {
            columns = AxellIO.readint("Informe o numero de colunas da matriz: ");
            AxellIO.println();
            
        } while (columns < 1 || columns > 10); // aceita quantidade do intervalo [1, 10]
        
        array = new double[lines][columns];
        
        for (int i = 0; i < columns; i++) // i representara' a coluna
        {
            for (int j = 0; j < lines; j++) // j representara' a linha
            {
                array[j][i] = element;
                element++;
            }
        }
        
        return array;
    }
    
    /**
     * Mostra arranjos bidimensionais
     * @param array 
     */
    
    public static void show2DArray(double[][] array)
    {
        AxellIO.println("Matriz:");
        
        for (double[] line : array)
        {
            for (double element : line)
            {
                AxellIO.print(element + " ");
            }
            
            AxellIO.println();
        }
    }
    
    /**
     * Salva um arranjo bidimensional com numeros reais em um arquivo
     * @param array arranjo bidimensional
     * @param fileName nome do arquivo a se gravar
     */
    
    public static void save2DArray(double[][] array, String fileName)
    {
        FILE file = new FILE(FILE.OUTPUT, fileName);
        
        for (double[] line : array) // percorre as linhas da matriz
        {
            for (double element : line) // percorre os elementos das linhas
            {
                file.print(element + " "); // imprimir o elemento
            }
            
            file.println(""); // pula uma linha
        }
        
        file.close(); // fecha o arquivo gravando os dados
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "MatrizE2.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        double array[][] = create2DArray();
        
        save2DArray(array, fileName);
        
        show2DArray(array);
        
        AxellIO.pause("\nPressione ENTER para finalizar");
    }
    
}