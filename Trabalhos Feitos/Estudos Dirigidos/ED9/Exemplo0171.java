/*

PUC Minas - Ciência da Computação     Nome: Exemplo0171

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 31/03/2018

*/

import java.io.IOException;

public class Exemplo0171
{
    /**
     * Cria um arranjo bidimensional de acordo com os dados do usuario
     * @return arranjo bidimensional informado pelo usuario
     */
    
    public static double[][] create2DArray() throws IOException
    {
        double array[][];
        int lines, columns;
        Double element;
        
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
        
        // percorre linhas e colunas pegando os elementos de cada uma
        for (int i = 0; i < lines; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                do
                {
                    element = AxellIO.readDouble("Linha: " + (i + 1) + ", coluna: " + (j + 1) + "\nInforme o elemento: ");
                    AxellIO.println();
                    
                } while (element == null || element.doubleValue() <= 0); // apenas elementos positivos
                
                array[i][j] = element;
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
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0171");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        double array[][] = create2DArray();
        
        show2DArray(array);
        
        AxellIO.pause("\nPressione ENTER para finalizar");
    }
    
}
