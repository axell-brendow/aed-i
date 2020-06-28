/*

PUC Minas - Ciência da Computação     Nome: Exemplo0156

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 23/03/2018

*/

import IO.*;

public class Exemplo0156
{
    /**
     * Cuida do caso em que a funcao IO.readint() retorna 0
     * @param element retorno de IO.readint()
     * @param i numero antecessor da ordem do elemento no arranjo
     * @return 0 ou outro valor se assim o usuario desejar.
     */
    
    public static int careAbout0(int element, int i)
    {
        if (element == 0)
        {
            String option;

            do
            {
                option = IO.readString("Considerar valor informado como zero (s-n)? ");
                IO.println();
                
            } while (!option.equals("s") && !option.equals("n"));
            
            if (option.equals("n"))
            {
                element = IO.readint("Informe o " + (i + 1) + "o numero inteiro: ");
                IO.println();
                
                element = careAbout0(element, i);
            }
        }
        
        return element;
    }
    
    /**
     * Le o numero de elementos do arranjo (tamanho) e solicita esses elementos
     * @param lowerLimit limite inferior de geracao dos numeros aleatorios
     * @param upperLimit limite superior de geracao dos numeros aleatorios
     * @return arranjo com os elementos
     */
    
    public static int[] readAndWriteArray(int lowerLimit, int upperLimit)
    {
        int[] array = null;
        int numberOfElements;
        
        numberOfElements = IO.readint("Informe a quantidade de elementos do arranjo: ");
        IO.println();
        
        if (numberOfElements < 1)
        {
            IO.println("Numero de elementos invalido");
        }
        
        else
        {
            array = new int[numberOfElements];
            int element;
            
            for (int i = 0; i < numberOfElements; i++)
            {
                element = (int) (lowerLimit + Math.random() * (upperLimit - lowerLimit));
                
                array[i] = element;
            }
        }
        
        return array;
    }
    
    public static String showArraySize(int[] array)
    {
        String data = "Numero de elementos do arranjo (tamanho): " + array.length;
        return data;
    }
    
    public static String showArrayElements(int[] array)
    {
        String data = "Arranjo:";
        
        for (int element : array)
        {
            data += "\n" + element;
        }
        
        return data;
    }
    
    /**
     * Salva informacoes num arquivo
     * @param array arranjo de inteiros a salvar
     * @param fileName nome do arquivo
     */
    
    public static void saveData(int[] array, String fileName)
    {
        FILE file = new FILE(FILE.OUTPUT, fileName);
        
        file.println(showArraySize(array));
        file.println(showArrayElements(array));
        
        file.close();
    }
    
    /**
     * Salva informacoes num arquivo
     * @param array arranjo a se analisar
     * @param fileName nome do arquivo
     */
    
    public static void saveData2(int[] array, String fileName)
    {
        // pega o nome do arquivo sem a extensao .txt
        String shortFileName = fileName.substring(0, fileName.length() - 4);
        
        fileName = shortFileName + "b.txt";
        
        FILE file = new FILE(FILE.OUTPUT, fileName); // arquivo dos valores maiores ou iguais
        
        double arithmeticMean = getArrayArithmeticMean(array);
        String numbers = "";
        
        for (int x : array)
        {
            if (x >= arithmeticMean)
            {
                file.println("" + x);
                numbers += x + " "; // mostrarei esses numeros na saida padrao tambem
            }
        }
        
        file.close();
        
        IO.println("Numeros maiores ou iguais 'a media: " + numbers);
        
        numbers = ""; // reseta os numeros
        
        fileName = shortFileName + "c.txt";
        
        file.open(FILE.OUTPUT, fileName); // arquivo dos valores menores
        
        for (int x : array)
        {
            if (x < arithmeticMean)
            {
                file.println("" + x);
                numbers += x + " "; // mostrarei esses numeros na saida padrao tambem
            }
        }
        
        file.close();
        
        IO.println("Numeros menores que a media: " + numbers);
    }
    
    /**
     * Le um arquivo em busca de um arranjo de inteiros
     * @param fileName nome do arquivo
     * @return arranjo com os inteiros do arquivo
     */
    
    public static int[] getArrayBack(String fileName)
    {
        int[] array = null; // cria a futura array recuperada
        int size, counter = 0;
        
        FILE file = new FILE(FILE.INPUT, fileName); // abre o arquivo
        String line; // guardara' cada linha do arquivo
        
        // pega a primeira linha que e' a que contem o numero de elementos do arranjo
        line = file.readln();
        
        if (line != null && !line.equals(""))
        {
            // pega o numero de elementos
            size = IO.getint(line.substring(line.indexOf(':') + 2));
            
            array = new int[size];
            
            line = file.readln(); // le a proxima linha, a que contem a palavra "Arranjos"
            line = file.readln(); // le a proxima linha, em que comecam os elementos do arranjo
            
            while (!file.eof() && line != null) // percorre as linhas do arquivo
            {
                array[counter] = IO.getint(line); // adiciona o numero da linha ao novo arranjo
                counter++;
                
                line = file.readln(); // le a proxima linha
            }
        }
        
        return array;
    }
    
    /**
     * Percorre um arranjo somando os elementos
     * @param array arranjo a percorrer
     * @return soma dos elementos do arranjo
     */
    
    public static int getArraySum(int[] array)
    {
        int sum = 0;
        
        for (int x : array)
        {
            sum += x;
        }
        
        return sum;
    }
    
    /**
     * Descobre a media aritmetica de um arranjo
     * @param array arranjo a se analisar
     * @return media aritmetica do arranjo
     */
    
    public static double getArrayArithmeticMean(int[] array)
    {
        return 1.0 * getArraySum(array) / array.length;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int[] array;
        int lowerLimit, upperLimit;
        String fileName = "Exemplo0156.txt";
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0156");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            lowerLimit = IO.readint("Informe o limite inferior de geracao aleatoria: ");
            IO.println();
            
        } while (lowerLimit == 0); // evitara' entradas decimais ou nao numericas
        
        do
        {
            upperLimit = IO.readint("Informe o limite superior de geracao aleatoria: ");
            IO.println();
            
        } while (upperLimit <= lowerLimit || upperLimit == 0); // evita limites invalidos
            
        array = readAndWriteArray(lowerLimit, upperLimit);
        
        if (array != null)
        {
            saveData(array, fileName); // grava arranjo no arquivo
            
            array = getArrayBack(fileName); // le arranjo do arquivo
            
            IO.println(showArraySize(array)); // mostra o tamanho
            IO.println();
            
            IO.println(showArrayElements(array)); // mostra os elementos
            IO.println();
            
            saveData2(array, fileName); // grava e mostra os numeros maiores e menores que a media
        }
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
