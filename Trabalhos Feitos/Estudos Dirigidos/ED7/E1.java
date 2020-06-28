/*

PUC Minas - Ciência da Computação     Nome: E1

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 21/03/2018

*/

import IO.*;

public class E1
{
    static String data = ""; // dados
    
    /**
     * Salva dados em arquivo
     */
    
    public static void saveData()
    {
        FILE file = new FILE(FILE.OUTPUT, "E1.txt");
        
        file.println(data);
        
        file.close();
    }
    
    /**
     * Obtem e concatena os divisores de um numero em ordem decrescente
     * @param numberToAnalize numero a se analisar
     */
    
    public static void getDivisors(int numberToAnalize)
    {
        for (int i = numberToAnalize; i > 0; i--) // comeca do numero e vai ate 1
        {
            // checa se o numero e' divisivel por seus antecessores
            if (numberToAnalize % i == 0)
            {
                data += i + " "; // adiciona o antecessor que for divisor
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberToAnalize;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E1");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberToAnalize = IO.readint("Informe o numero a se obter os divisores: ");
            IO.println();
            
        } while (numberToAnalize == 0); // evita entradas decimais ou nao numericas
        
        getDivisors(numberToAnalize);
        
        saveData();
        
        IO.pause("Pressione ENTER para terminar");
    }
    
}
