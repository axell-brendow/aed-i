/*

PUC Minas - Ciência da Computação     Nome: E1

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 23/03/2018

*/

import IO.*;

public class E1
{
    /**
     * Obtem e concatena os divisores de um numero em ordem decrescente
     * @param numberToAnalize numero a se analisar
     */
    
    public static int[] getDivisors(int numberToAnalize)
    {
        int[] divisors = new int[numberToAnalize];
        int divisorIndex = 0;
        
        for (int i = numberToAnalize; i > 0; i--) // comeca do numero e vai ate 1
        {
            // checa se o numero e' divisivel por seus antecessores
            if (numberToAnalize % i == 0)
            {
                divisors[divisorIndex] = i; // adiciona o antecessor que for divisor
                divisorIndex++;
            }
        }
        
        return divisors;
    }
    
    public static String showArrayElements(int[] array)
    {
        String data = "Arranjo:";
        
        for (int element : array)
        {
            if (element != 0) // checa se o elemento é diferente do inteiro padrão
            {
                data += "\n" + element;
            }
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
        
        file.println(showArrayElements(array));
        
        file.close();
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int[] array;
        int number;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E1");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            number = IO.readint("Informe o numero a se obter os divisores: ");
            IO.println();
            
        } while (number < 1);
        
        array = getDivisors(number);
        
        IO.println(showArrayElements(array));
        
        saveData(array, "DIVISORES.TXT");
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
