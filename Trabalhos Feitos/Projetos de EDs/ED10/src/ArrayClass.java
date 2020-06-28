import java.io.IOException;
import IO.*;

class ArrayClass
{
    public Object array[];
    
    public ArrayClass() {}
    
    public ArrayClass(int size)
    {
        if (size > 0)
        {
            array = new Object[size];
        }
    }
    
    /**
     * Limpar o arranjo da classe igualando todos os elementos a null
     */
    
    public void clearArray()
    {
        if (array == null) return;
        
        for (int i = 0; i < array.length; i++)
        {
            array[i] = null;
        }
    }
    
    /**
     * Funcao que obtem a representacao de certa quantidade de elementos
     * do arranjo da classe na forma de texto
     * @param start indice do primeiro elemento a se pegar
     * @param numberOfElements quantidade de elementos a se pegar
     * @return elementos concatenados entre espacos na forma de String
     */
    
    private String getArrayText(int start, int numberOfElements)
    {
        if (array == null || limitWillBreak(start, numberOfElements, array))
        {
            AxellIO.println("\nNao foi possivel obter a representacao em texto do arranjo da classe");
            return null;
        }
        
        String arrayText = "";
        
        for (int i = 0; i < numberOfElements; i++)
        {
            arrayText += array[start + i] + " ";
        }
        
        return arrayText;
    }
    
    /**
     * Mostra certa quantidade de elementos do arranjo da classe
     * a partir de um indice inicial
     * @param start indice do primeiro elemento a se mostrar
     * @param numberOfElements quantidade de elementos a se mostrar
     */
    
    public void printArray(int start, int numberOfElements)
    {
       String arrayText = getArrayText(start, numberOfElements);
       
       if (arrayText == null) return;
       
       AxellIO.println(arrayText);
    }
    
    /**
     * Mostra todos os elementos do arranjo da classe
     */
    
    public void printArray()
    {
        AxellIO.println("" + this);
    }
    
    /**
     * Salva um arranjo de objetos no arranjo da classe a partir de uma posicao inicial
     * @param start indice de comeco da gravacao
     * @param elements arranjo de objetos a serem gravados
     * @return true se os parametros anteriores nao levarem a um erro
     */
    
    private boolean saveOnRange(int start, Object[] elements)
    {
        // cuida de todos os possiveis casos de dados incorretos. (espero eu kk)
        if (array == null || elements == null || limitWillBreak(start, elements.length, array))
        {
            AxellIO.println("\nNao foi possivel gravar os elementos no arranjo da classe");
            return false;
        }
        
        for (int i = 0; i < elements.length; i++) // percorre a quantidade de elementos
        {
            // associa cada objeto de "elements" a "array" a partir da posicao "start"
            array[start + i] = elements[i];
        }
        
        return true;
    }
    
    /**
     * Cria um arranjo de Strings especificas
     * @param text texto a ser mostrado para o usuario antes da obtencao de cada String
     * @param numberOfElements quantidade de elementos do arranjo
     * @param accept caractere que indicara' qual e' o tipo de String especifica
     * @return arranjo de Strings especificas
     */
    
    private String[] createStringArray(String text, int numberOfElements, char accept) throws IOException
    {
        if (numberOfElements < 1)
        {
            AxellIO.println("\nQuantidade de elementos invalida");
            return null;
        }
        
        String[] stringArray = new String[numberOfElements];
        String element;
        
        for (int i = 0; i < numberOfElements; i++) // percorre a quantidade de elementos
        {
            element = AxellIO.readSpecificString(text, accept); // le a String especifica
            
            while (element == null) // fica no looping enquanto a String nao for a desejada
            {
                AxellIO.println("\nEntrada invalida. Novamente,");
                element = AxellIO.readSpecificString(text, accept); // le novamente
            }
            
            stringArray[i] = element; // guarda a String correta no arranjo de Strings
        }
        
        return stringArray;
    }
    
    /**
     * Cria um arranjo de Integers
     * @param text texto a ser mostrado para o usuario antes da obtencao de cada Integer
     * @param numberOfElements quantidade de elementos do arranjo
     * @return arranjo de Integers
     */
    
    private Integer[] createIntArray(String text, int numberOfElements) throws IOException
    {
        // cria um arranjo de Strings que contem digitos
        String[] stringArray = createStringArray(text, numberOfElements, 'd');
        
        if (stringArray == null) return null;
        
        Integer[] intArray = new Integer[stringArray.length]; // futuro arranjo de inteiros
        
        // percorre o arranjo de Strings
        for (int i = 0; i < stringArray.length; i++)
        {
            intArray[i] = Integer.valueOf(stringArray[i]); // converte a String para Integer
        }
        
        return intArray;
    }
    
    /**
     * Le um arranjo de Integers e o grava no arranjo da classe
     * a partir de um indice inicial
     * @param text texto a ser mostrado para o usuario antes da obtencao de cada Integer
     * @param start indice de comeco da gravacao no arranjo da classe
     * @param numberOfElements quantidade de elementos a serem lidos
     */
    
    public void readIntArray(String text, int start, int numberOfElements) throws IOException
    {
        saveOnRange(start, createIntArray(text, numberOfElements));
    }
    
    /**
     * Le um arranjo de Integers que preenchera' todos os espacos do arranjo da classe
     * @param text texto a ser mostrado para o usuario antes da obtencao de cada Integer
     */
    
    public void readIntArray(String text) throws IOException
    {
        if (array == null) return;
        
        readIntArray(text, 0, array.length);
    }
    
    /**
     * Le um arquivo contendo um arranjo linear
     * @param fileName nome do arquivo
     * @return arranjo linear
     */
    
    private String[] getArrayFromFile(String fileName)
    {
        String[] arrayFromFile = null; // guardara' cada elemento do arquivo
        
        FILE file = new FILE(FILE.INPUT, fileName);
        String line = file.readln(); // le a primeira linha do arquivo
        
        if (!file.eof() && line != null && !line.equals(""))
        {
            arrayFromFile = line.split(" "); // pega cada elemento do arquivo
        }
        
        file.close();
        
        return arrayFromFile;
    }
    
    /**
     * Obtem um arranjo linear de um arquivo e o grava no arranjo da classe
     * @param fileName nome do arquivo
     */
    
    public void fromFile(String fileName)
    {
        saveOnRange(0, getArrayFromFile(fileName));
    }
    
    /**
     * Grava o arranjo da classe em um arquivo
     * @param fileName nome do arquivo
     */
    
    public void toFile(String fileName)
    {
        FILE file = new FILE(FILE.OUTPUT, fileName);
        
        file.print("" + this);
        
        file.close();
    }
    
    /**
     * Obtem um arranjo linear de um arquivo
     * @param fileName nome do arquivo
     * @param start imaginando o arquivo como um arranjo, esse parametro
     * representaria o indice de comeco para obter os elementos
     * @param numberOfElements quantidade de elementos a se obter
     * @return arranjo linear extraido do arquivo
     */
    
    private String[] getArrayFromFile(String fileName, int start, int numberOfElements)
    {
        String[] splitedLine; // guardara' cada elemento do arquivo
        String[] arrayFromFile = null;
        
        FILE file = new FILE(FILE.INPUT, fileName);
        String line = file.readln(); // le a primeira linha do arquivo
        
        if (!file.eof() && line != null && !line.equals(""))
        {
            splitedLine = line.split(" "); // pega cada elemento do arquivo
            
            // checa se o indice de inicio e a quantidade de elementos nao irao
            // levar o algoritmo a ultrapassar a quantidade de elementos do arquivo
            if (!limitWillBreak(start, numberOfElements, splitedLine))
            {
                // aloca o espaco para o arranjo que sera' retornado
                arrayFromFile = new String[numberOfElements];
                
                for (int i = 0; i < numberOfElements; i++) // percorre a quantidade de elementos
                {
                    // adiciona os elementos do arquivo para o arranjo
                    arrayFromFile[i] = splitedLine[start + i];
                }
            }
        }
        
        file.close();
        
        return arrayFromFile;
    }
    
    /**
     * Obtem um arranjo linear de um arquivo e o grava no arranjo da classe
     * @param fileName nome do arquivo
     * @param numberOfElements quantidade de elementos a se obter
     */
    
    public void fromFile(String fileName, int numberOfElements)
    {
        saveOnRange(0, getArrayFromFile(fileName, 0, numberOfElements));
    }
    
    /**
     * Grava certa quantidade de elementos do arranjo da classe em arquivo
     * @param fileName nome do arquivo
     * @param start indice do primeiro elemento do arranjo a se gravar
     * @param numberOfElements quantidade de elementos a se gravar
     */
    
    public void toFile(String fileName, int start, int numberOfElements)
    {
        FILE file = new FILE(FILE.OUTPUT, fileName);
        
        file.print(getArrayText(start, numberOfElements));
        
        file.close();
    }
    
    /**
     * Grava certa quantidade de elementos do arranjo da classe em arquivo
     * @param fileName nome do arquivo
     * @param numberOfElements quantidade de elementos a se gravar
     */
    
    public void toFile(String fileName, int numberOfElements)
    {
        toFile(fileName, 0, numberOfElements);
    }
    
    /**
     * Obtem um arranjo linear de um arquivo e o grava no arranjo da classe
     * @param fileName nome do arquivo
     * @param start imaginando o arquivo como um arranjo, esse parametro
     * representaria o indice de comeco para obter os elementos
     * @param numberOfElements quantidade de elementos a se obter
     */
    
    public void fromFile(String fileName, int start, int numberOfElements)
    {
        saveOnRange(start, getArrayFromFile(fileName, start, numberOfElements));
    }
    
    /**
     * Obtem um arranjo de objetos invertido em relacao ao arranjo da classe
     * @return arranjo de objetos invertido
     */
    
    public Object[] invertArray()
    {
        if (array == null) return null;
        
        Object[] invertedArray = new Object[array.length];
        
        for (int i = 0; i < array.length; i++)
        {
            invertedArray[i] = array[array.length - i - 1];
        }
        
        return invertedArray;
    }
    
    /**
     * Copia certa quantidade de elementos do arranjo da classe a partir
     * de um indice inicial
     * @param start indice inicial
     * @param numberOfElements quantidade de elementos
     * @return arranjo de objetos com os objetos do arranjo da classe
     */
    
    public Object[] copyArray(int start, int numberOfElements)
    {
        if (array == null || limitWillBreak(start, numberOfElements, array)) return null;
        
        Object[] copyOfClassArray = new Object[numberOfElements];
        
        for (int i = 0; i < numberOfElements; i++)
        {
            copyOfClassArray[i] = array[start + i];
        }
        
        return copyOfClassArray;
    }
    
    /**
     * Checa se, a partir de um indice inicial, e' impossivel acessar certa quantidade
     * de elementos ou espacos de um arranjo
     * @param start indice inicial
     * @param numberOfElements quantidade de elementos
     * @param objectArray arranjo a ser analisado
     * @return true se for impossivel, caso contrario, false
     */
    
    private boolean limitWillBreak(int start, int numberOfElements, Object[] objectArray)
    {
        if (start < 0 || numberOfElements < 1 || (start + numberOfElements) > objectArray.length)
        {
            AxellIO.println("\nIndice inicial e a quantidade de elementos levam a erro");
            return true;
        }
        
        return false;
    }
    
    @Override
    public ArrayClass clone() throws CloneNotSupportedException
    {
        if (array == null) return new ArrayClass();
        
        ArrayClass arrayClass = new ArrayClass(array.length);
        
        arrayClass.array = copyArray(0, array.length);
        
        return arrayClass;
    }
    
    @Override
    public String toString()
    {
        if (array == null) return null;
        
        return getArrayText(0, array.length);
    }
    
    public boolean equals(ArrayClass arrayClass)
    {
        return toString().equals(arrayClass.toString());
    }
}