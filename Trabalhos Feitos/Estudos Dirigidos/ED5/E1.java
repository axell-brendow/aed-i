/*

PUC Minas - Ciência da Computação     Nome: E1

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/03/2018

*/

import IO.*;

public class E1
{
    /**
     * Obtem o fatorial de um numero
     * @param number numero a se obter o fatorial
     * @return fatorial do numero
     */
    
    public static int getFactorial(int number)
    {
        int factorial = 1; // 0! e 1! = 1 por definicao
        String process = number + "! = "; // guardara' a expressao do fatorial
        
        if (number != 0 && number != 1) // checa se o numero nao e' 0 nem 1
        {
            // contagem decrescente assim como as multiplicacoes da operacao fatorial
            for (int i = number; i > 0; i--)
            {
                process += i + "*";
                
                factorial *= i;
            }
        }
        else
        {
            process += "1";
            
            IO.println(process);
        
            return factorial;
        }
        
        // retira o ultimo asterisco "*"
        process = process.substring(0, process.length() - 1);
        
        IO.println(process);
        
        return factorial;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int number;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E1");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            number = IO.readint("Informe o numero a se obter o fatorial: ");
            IO.println();
            
        } while(number < 0);
        
        IO.println("\nFatorial: " + getFactorial(number));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
