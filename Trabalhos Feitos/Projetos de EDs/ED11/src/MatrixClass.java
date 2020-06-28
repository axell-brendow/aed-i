import java.io.IOException;
import IO.*;

class MatrixClass
{
    private Object matrix[][];
    
    public MatrixClass() {}
    
    public MatrixClass(int lines, int columns)
    {
        if (lines > 0 && columns > 0)
        {
            matrix = new Object[lines][columns];
        }
    }
    
    /**
     * Limpar a matriz da classe igualando todos os elementos a null
     */
    
    public void clearMatrix()
    {
        for (int i = 0; i < linesOf(matrix); i++)
        {
            for (int j = 0; j < columnsOf(matrix); j++)
            {
                matrix[i][j] = null;
            }
        }
    }
    
    private String getMatrixText(int startLine, int numberOfLines, int startColumn, int numberOfColumns)
    {
        if (matrix == null || limitWillBreak(startLine, numberOfLines, startColumn, numberOfColumns, matrix))
        {
            AxellIO.println("\nNao foi possivel obter a representacao em texto da matriz da classe");
            return null;
        }
        
        String matrixText = "";
        
        for (int i = 0; i < numberOfLines; i++)
        {
            for (int j = 0; j < numberOfColumns; j++)
            {
                matrixText += matrix[startLine + i][startColumn + j] + " ";
            }
            
            matrixText += AxellIO.LINE_SEPARATOR;
        }
        
        return matrixText;
    }
    
    public void printMatrix(int startLine, int numberOfLines, int startColumn, int numberOfColumns)
    {
       String matrixText = getMatrixText(startLine, numberOfLines, startColumn, numberOfColumns);
       
       if (matrixText == null) return;
       
       AxellIO.print(matrixText);
    }
    
    /**
     * Mostra todos os elementos da matriz da classe
     */
    
    public void printMatrix()
    {
        AxellIO.print("" + this);
    }
    
    public void printMatrix(Object[][] matrix)
    {
        if (matrix == null) return;
        
        for (Object[] line : matrix)
        {
            for (Object element : line)
            {
                AxellIO.print(element + " ");
            }
            
            AxellIO.println();
        }
    }
    
    private boolean saveOnRange(int startLine, int startColumn, Object[][] elements)
    {
        // cuida de todos os possiveis casos de dados incorretos. (espero eu kk)
        if (matrix == null || elements == null || limitWillBreak(startLine, linesOf(elements), startColumn, columnsOf(elements), matrix))
        {
            AxellIO.println("\nNao foi possivel gravar os elementos na matriz da classe");
            return false;
        }
        
        for (int i = 0; i < linesOf(elements); i++)
        {
            for (int j = 0; j < columnsOf(elements); j++)
            {
                matrix[startLine + i][startColumn + j] = elements[i][j];
            }
        }
        
        return true;
    }
    
    private String[][] createStringMatrix(String text, int numberOfLines, int numberOfColumns, char accept) throws IOException
    {
        if (numberOfLines < 1 || numberOfColumns < 1)
        {
            AxellIO.println("\nQuantidade de linhas ou quantidade de colunas invalida");
            return null;
        }
        
        String[][] stringMatrix = new String[numberOfLines][numberOfColumns];
        String element;
        
        for (int i = 0; i < numberOfLines; i++)
        {
            for (int j = 0; j < numberOfColumns; j++)
            {
                element = AxellIO.readSpecificString("Linha: " + (i + 1) + ", coluna: " + (j + 1) + "\n" + text, accept); // le a String especifica
                AxellIO.println();
                
                while (element == null) // fica no looping enquanto a String nao for a desejada
                {
                    AxellIO.println("\nEntrada invalida. Novamente,\nLinha: " + (i + 1) + ", coluna: " + (j + 1));
                    element = AxellIO.readSpecificString(text, accept); // le novamente
                    AxellIO.println();
                }

                stringMatrix[i][j] = element; // guarda a String correta na matriz de Strings
            }
        }
        
        return stringMatrix;
    }
    
    private Integer[][] createIntMatrix(String text, int numberOfLines, int numberOfColumns) throws IOException
    {
        // cria um matriz de Strings que contem digitos
        String[][] stringMatrix = createStringMatrix(text, numberOfLines, numberOfColumns, 'd');
        
        if (stringMatrix == null) return null;
        
        Integer[][] intMatrix = new Integer[linesOf(stringMatrix)][columnsOf(stringMatrix)]; // futura matriz de inteiros
        
        for (int i = 0; i < numberOfLines; i++)
        {
            for (int j = 0; j < numberOfColumns; j++)
            {
                intMatrix[i][j] = Integer.valueOf(stringMatrix[i][j]); // converte a String para Integer
            }
        }
        
        return intMatrix;
    }
    
    public void readIntMatrix(String text, int startLine, int numberOfLines, int startColumn, int numberOfColumns) throws IOException
    {
        saveOnRange(startLine, startColumn, createIntMatrix(text, numberOfLines, numberOfColumns));
    }
    
    public void readIntMatrix(String text) throws IOException
    {
        if (matrix == null) return;
        
        readIntMatrix(text, 0, linesOf(matrix), 0, columnsOf(matrix));
    }
    
    private int getFileLines(String fileName)
    {
        FILE file = new FILE(FILE.INPUT, fileName);
        String line = file.readln();
        int numberOfLines = 0;
        
        while (!file.eof() && line != null)
        {
            if (!line.equals(""))
            {
                numberOfLines++;
            }
            
            line = file.readln();
        }
        
        file.close();
        
        return numberOfLines;
    }
    
    private int getFileColumns(String fileName)
    {
        FILE file = new FILE(FILE.INPUT, fileName);
        String line = file.readln();
        int numberOfColumns = 0;
        
        while (!file.eof() && line != null && numberOfColumns == 0)
        {
            if (!line.equals(""))
            {
                numberOfColumns = line.split(" ").length;
            }
            
            line = file.readln();
        }
        
        file.close();
        
        return numberOfColumns;
    }
    
    private String[][] getMatrixFromFile(String fileName)
    {
        FILE file = new FILE(FILE.INPUT, fileName);
        
        String[][] matrixFromFile = null; // guardara' cada elemento do arquivo
        
        int counter = 0;
        String line = file.readln(); // le a primeira linha do arquivo
        
        if (!file.eof() && line != null && !line.equals(""))
        {
            matrixFromFile = new String[getFileLines(fileName)][getFileColumns(fileName)];
            
            matrixFromFile[counter] = line.split(" "); // pega cada elemento da primeira linha
            counter++;
            
            line = file.readln();
            
            while (!file.eof() && line != null)
            {
                if (!line.equals(""))
                {
                    matrixFromFile[counter] = line.split(" "); // pega cada elemento do arquivo
                    counter++;
                }

                line = file.readln();
            }
        }
        
        file.close();
        
        return matrixFromFile;
    }
    
    /**
     * Obtem uma matriz de um arquivo e a grava na matriz da classe
     * @param fileName nome do arquivo
     */
    
    public void fromFile(String fileName)
    {
        saveOnRange(0, 0, getMatrixFromFile(fileName));
    }
    
    /**
     * Grava a matriz da classe em um arquivo
     * @param fileName nome do arquivo
     */
    
    public void toFile(String fileName)
    {
        FILE file = new FILE(FILE.OUTPUT, fileName);
        
        file.print("" + this);
        
        file.close();
    }
    
    private String[][] getMatrixFromFile(String fileName, int startLine, int numberOfLines, int startColumn, int numberOfColumns)
    {
        String[] splitedLine;
        String[][] matrixFromFile = null;
        int lineCounter = 0, fileLineCounter = 0;
        
        FILE file = new FILE(FILE.INPUT, fileName);
        String line = file.readln(); // le a primeira linha do arquivo
        
        while (fileLineCounter < startLine && !file.eof() && line != null)
        {
            if (!line.equals(""))
            {
                fileLineCounter++;
            }
            
            line = file.readln();
        }
        
        if (fileLineCounter >= startLine && !file.eof() && line != null && !line.equals(""))
        {
            matrixFromFile = new String[numberOfLines][numberOfColumns];
            
            splitedLine = line.split(" ");
            
            for (int i = 0; i < numberOfColumns; i++)
            {
                matrixFromFile[lineCounter][i] = splitedLine[startColumn + i];
            }
            
            lineCounter++;
            line = file.readln(); // le a proxima linha do arquivo
            
            while (!file.eof() && line != null && lineCounter < numberOfLines)
            {
                if (!line.equals(""))
                {
                    splitedLine = line.split(" ");
                    
                    for (int i = 0; i < numberOfColumns; i++)
                    {
                        matrixFromFile[lineCounter][i] = splitedLine[startColumn + i];
                    }

                    lineCounter++;
                }

                line = file.readln();
            }
        }
        
        file.close();
        
        return matrixFromFile;
    }
    
    public void fromFile(String fileName, int numberOfLines, int numberOfColumns)
    {
        saveOnRange(0, 0, getMatrixFromFile(fileName, 0, numberOfLines, 0, numberOfColumns));
    }
    
    public void toFile(String fileName, int startLine, int numberOfLines, int startColumn, int numberOfColumns)
    {
        FILE file = new FILE(FILE.OUTPUT, fileName);
        
        file.print(getMatrixText(startLine, numberOfLines, startColumn, numberOfColumns));
        
        file.close();
    }
    
    public void toFile(String fileName, int numberOfLines, int numberOfColumns)
    {
        toFile(fileName, 0, numberOfLines, 0, numberOfColumns);
    }
    
    public void fromFile(String fileName, int startLine, int numberOfLines, int startColumn, int numberOfColumns)
    {
        saveOnRange(startLine, startColumn, getMatrixFromFile(fileName, startLine, numberOfLines, startColumn, numberOfColumns));
    }
    
    public Object[][] copyMatrix(int startLine, int numberOfLines, int startColumn, int numberOfColumns)
    {
        if (matrix == null || limitWillBreak(startLine, numberOfLines, startColumn, numberOfColumns, matrix)) return null;
        
        Object[][] copyOfClassMatrix = new Object[numberOfLines][numberOfColumns];
        
        for (int i = 0; i < numberOfLines; i++)
        {
            for (int j = 0; j < numberOfColumns; j++)
            {
                copyOfClassMatrix[i][j] = matrix[startLine + i][startColumn + j];
            }
        }
        
        return copyOfClassMatrix;
    }
    
    public boolean isNullAboveMainDiagonal(Object[][] array, int lines)
    {
        boolean isNull = true;
        int i = 0, j;
        
        while (i < lines && isNull) // percorre as colunas do arranjo 2D
        {
            j = i - 1;
            // percorre as linhas abaixo do atual elemento da diagonal principal
            while (j >= 0 && isNull)
            {
                isNull = Double.parseDouble(array[j][i].toString()) == 0;
                j--;
            }
            
            i++;
        }
        
        return isNull;
    }
    
    public boolean isNullBelowMainDiagonal(Object[][] array, int lines)
    {
        boolean isNull = true;
        int i = 0, j;
        
        while (i < lines && isNull) // percorre as colunas do arranjo 2D
        {
            j = i + 1;
            // percorre as linhas abaixo do atual elemento da diagonal principal
            while (j < lines && isNull)
            {
                isNull = Double.parseDouble(array[j][i].toString()) == 0;
                j++;
            }
            
            i++;
        }
        
        return isNull;
    }
    
    public boolean isInferiorTriangular()
    {
        if (matrix == null) return false;
        
        int lines = linesOf(matrix), columns = columnsOf(matrix);
        
        if (lines != columns || (lines == 0 && columns == 0)) return false;
        
        return !isNullBelowMainDiagonal(matrix, lines) && isNullAboveMainDiagonal(matrix, lines);
    }
    
    public boolean isSuperiorTriangular()
    {
        if (matrix == null) return false;
        
        int lines = linesOf(matrix), columns = columnsOf(matrix);
        
        if (lines != columns || (lines == 0 && columns == 0)) return false;
        
        return isNullBelowMainDiagonal(matrix, lines) && !isNullAboveMainDiagonal(matrix, lines);
    }
    
    public int linesOf(Object[][] objectMatrix)
    {
        return objectMatrix == null ? 0 : objectMatrix.length;
    }
    
    public int columnsOf(Object[][] objectMatrix)
    {
        return objectMatrix == null || objectMatrix[0] == null ? 0 : objectMatrix[0].length;
    }
    
    private boolean linesLimitWillBreak(int startLine, int numberOfLines, Object[][] objectMatrix)
    {
        if (startLine < 0 || numberOfLines < 1 || (startLine + numberOfLines) > linesOf(objectMatrix))
        {
            AxellIO.println("\nIndice inicial e a quantidade de elementos levam a erro nas linhas");
            return true;
        }
        
        return false;
    }
    
    private boolean columnsLimitWillBreak(int startColumn, int numberOfColumns, Object[][] objectMatrix)
    {
        if (startColumn < 0 || numberOfColumns < 1 || (startColumn + numberOfColumns) > columnsOf(objectMatrix))
        {
            AxellIO.println("\nIndice inicial e a quantidade de elementos levam a erro nas colunas");
            return true;
        }
        
        return false;
    }
    
    private boolean limitWillBreak(int startLine, int numberOfLines, int startColumn, int numberOfColumns, Object[][] matrixObject)
    {
        return linesLimitWillBreak(startLine, numberOfLines, matrixObject) || columnsLimitWillBreak(startColumn, numberOfColumns, matrixObject);
    }
    
    @Override
    public MatrixClass clone() throws CloneNotSupportedException
    {
        if (matrix == null) return new MatrixClass();
        
        int lines = linesOf(matrix), columns = columnsOf(matrix);
        
        MatrixClass matrixClass = new MatrixClass(lines, columns);
        
        matrixClass.matrix = copyMatrix(0, lines, 0, columns);
        
        return matrixClass;
    }
    
    @Override
    public String toString()
    {
        return getMatrixText(0, linesOf(matrix), 0, columnsOf(matrix));
    }
    
    public boolean equals(MatrixClass matrixClass)
    {
        return toString().equals(matrixClass.toString());
    }
}