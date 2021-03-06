/*

PUC Minas - Ciência da Computação     Nome: Exemplo0160

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 23/03/2018

*/

import IO.*;
import java.util.ArrayList;

public class Exemplo0160
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
     * @return arranjo com os elementos
     */
    
    public static int[] readAndWriteArray()
    {
        int[] array = null;
        int numberOfElements;
        
        numberOfElements = IO.readint("Informe quantos numeros inteiros colocara' no arranjo: ");
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
                element = IO.readint("Informe o " + (i + 1) + "o numero inteiro: ");
                IO.println();
                
                /*
                como nao e' possivel saber se o usuario digitou 0 ou um numero decimal
                ou um caractere que nao e' um digito, quando a funcao IO.readint()
                retornar 0, vou perguntar ao usuario se e' para considerar a entrada
                como 0 ou nao, caso nao, voltarei a perguntar o numero
                */
                element = careAbout0(element, i);
                
                array[i] = element;
            }
        }
        
        return array;
    }
    
    public static void showArraySize(int[] array)
    {
        IO.println("Numero de elementos do arranjo (tamanho): " + array.length);
    }
    
    public static void showArrayElements(int[] array)
    {
        IO.print("Arranjo: ");
        
        for (int element : array)
        {
            IO.print(element + " ");
        }
        
        IO.println();
    }
    
    /**
     * Percorre um arranjo verificando quantos vezes e' possivel achar um elemento dada uma posicao inicial
     * @param array arranjo a percorrer
     * @param value valor a procurar
     * @param startPosition posicao de comeco da busca
     * @return quantas vezes e' possivel achar o valor
     */
    
    public static ArrayList findNumberOfValuesByStartPosition(int[] array, int value, int startPosition)
    {
        ArrayList list = new ArrayList();
        
        int numberOfValues = 0;
        
        for (int i = startPosition - 1; i < array.length; i++)
        {
            if (array[i] == value) // se valor encontrado
            {
                numberOfValues++; // aumenta a quantidade de valores
                list.add(i); // guarda a posicao do valor encontrado
            }
        }
        
        list.add(numberOfValues); // adiciona o numero de valores encontrados
        
        return list;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int[] array;
        int value, startPosition, numberOfValues;
        ArrayList list;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0160");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        array = readAndWriteArray();
        
        if (array != null)
        {
            showArraySize(array);
            showArrayElements(array);
            
            do
            {
                value = IO.readint("\nInforme um valor a procurar no arranjo: ");
                
            } while (value == 0); // evitara' valores decimais ou nao numericos
            
            IO.println();
            
            do
            {
                startPosition = IO.readint("Comecando do 1, informe a posicao inicial de procura: ");
                IO.println();
                
            } while (startPosition < 1 || startPosition > array.length); // evitara' posicoes invalidas
            
            list = findNumberOfValuesByStartPosition(array, value, startPosition);
            
            numberOfValues = (int) list.get(list.size() - 1); // pega a quantidade de valores encontrados
            
            if (numberOfValues != 0)
            {
                IO.println(numberOfValues + " valores foram encontrados");
                IO.print("Comecando do 0, suas posicoes sao: ");
                
                for (int i = 0; i < list.size() - 1; i++)
                {
                    IO.print(list.get(i) + " ");
                }
                
                IO.println();
            }
            
            else
            {
                IO.println("Nao e' possivel encontrar o valor comecando pela posicao inicial informada");
            }
        }
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
