/*

PUC Minas - Ciência da Computação     Nome: Exemplo0176

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 03/04/2018

*/

import java.io.IOException;
import IO.*;

public class Exemplo0176
{
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
                // corta a linha em partes que estao separadas por espacos em branco
                splitedLine = line.split(" ");
                
                for (int i = 0; i < splitedLine.length; i++) // percorre as partes cortadas
                {
                    // adiciona as partes em forma de numero real no arranjo
                    array[lineCount][i] = IO.getdouble(splitedLine[i]);
                }
                
                lineCount++; // pula para a proxima linha do arranjo 2D
            }
            
            line = file.readln(); // le a proxima linha do arquivo
        }
        
        file.close();
        
        return array;
    }
    
    public static void showAboveMainDiagonal(double[][] array, int lines)
    {
        for (int i = 0; i < lines; i++) // percorre as linha do arranjo 2D
        {
            // percorre as linhas acima do atual elemento da diagonal principal
            for (int j = i - 1; j >= 0; j--)
            {
                // mostra cada elemento subindo
                AxellIO.print(array[j][i] + " ");
            }
            
            AxellIO.println();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException
    {
        String fileName = "Matriz.txt";
        
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0176");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        double array[][] = get2DArrayFromFile(fileName);
        
        showAboveMainDiagonal(array, getFileLines(fileName));
        
        AxellIO.pause("\nPressione ENTER para finalizar");
    }
    
}
