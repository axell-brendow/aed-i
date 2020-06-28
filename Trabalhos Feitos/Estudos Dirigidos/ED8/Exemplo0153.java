/*

PUC Minas - Ciência da Computação     Nome: Exemplo0153

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 23/03/2018

*/

import IO.*;

public class Exemplo0153
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
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int[] array;
        int lowerLimit, upperLimit;
        String fileName = "Exemplo0153.txt";
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0153");
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
            saveData(array, fileName); // grava array no arquivo
            
            IO.println(showArraySize(array)); // mostra o tamanho
            IO.println();
            IO.println(showArrayElements(array)); // mostra os elementos
        }
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
