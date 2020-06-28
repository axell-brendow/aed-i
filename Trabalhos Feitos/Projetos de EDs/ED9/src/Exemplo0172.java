/*

PUC Minas - Ciência da Computação     Nome: Exemplo0172

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 02/04/2018

*/

import java.io.IOException;
import IO.*;

public class Exemplo0172
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
     * Percorre um arquivo contando as linhas nao vazias
     * @param fileName nome do arquivo
     * @return quantidade de linhas nao vazias
     */
    
    public static int getFileLines(String fileName)
    {
        FILE file = new FILE(FILE.INPUT, fileName);
        String line = file.readln();
        int lines = 0;
        
        while (!file.eof() && line != null)
        {
            if (!line.equals(""))
            {
                lines++;
            }
            
            line = file.readln();
        }
        
        file.close();
        
        return lines;
    }
    
    /**
     * Percorre a primeira linha nao vazia do arquivo contando a
     * quantidade espacos que simbolizara' tambem a quantidade de
     * colunas do arranjo bidimensional
     * @param fileName nome do arquivo
     * @return quantidade de colunas do arranjo
     */
    
    public static int getFileColumns(String fileName)
    {
        FILE file = new FILE(FILE.INPUT, fileName);
        String line = file.readln();
        int columns = 0;
        
        while (!file.eof() && line != null && columns == 0)
        {
            if (!line.equals("")) // checa se linha nao esta' vazia
            {
                columns = AxellIO.getCharTimes(' ', line);
            }
            
            line = file.readln();
        }
        
        file.close();
        
        return columns;
    }
    
    /**
     * Le um arquivo contendo um arranjo 2D com numeros reais
     * @param fileName nome do arquivo
     * @return arranjo bidimensional
     */
    
    public static double[][] get2DArrayFromFile(String fileName)
    {
        FILE file = new FILE(FILE.INPUT, fileName);
        String line = file.readln();
        String[] splitedLine; // guardara' cada numero real da linha lida
        int lineCount = 0; // comeca da linha 0
        
        double[][] array = new double[getFileLines(fileName)][getFileColumns(fileName)];
        
        while (!file.eof() && line != null)
        {
            if (!line.equals("")) // se linha nao vazia
            {
                // corta a linha em partes que eram separadas por espacos em branco
                splitedLine = line.split(" ");
                
                for (int i = 0; i < splitedLine.length; i++) // percorre as partes cortadas
                {
                    // adiciona os numeros ao arranjo
                    array[lineCount][i] = IO.getdouble(splitedLine[i]);
                }
                
                lineCount++;
            }
            
            line = file.readln();
        }
        
        file.close();
        
        return array;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0172");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        String fileName = "Matriz0172.txt";
        
        double array[][] = create2DArray();
        
        save2DArray(array, fileName);
        
        array = get2DArrayFromFile(fileName);
        
        show2DArray(array);
        
        AxellIO.pause("\nPressione ENTER para finalizar");
    }
    
}