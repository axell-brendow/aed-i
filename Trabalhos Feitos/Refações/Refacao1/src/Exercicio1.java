/*

PUC Minas - Ciencia da Computacao     Nome: Exercicio1

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 09/04/2018

*/

import IO.*;

public class Exercicio1
{
    
    public static int getSequenceTerm(int termPosition)
    {
        int sum = 0;
        boolean sum1 = true;
        
        for (int i = 0; i < termPosition; i++)
        {
            if (sum1)
            {
                sum += 1;
                sum1 = false;
            }
            
            else
            {
                sum += 4;
                sum1 = true;
            }
            
            IO.print(sum + " ");
        }
        
        IO.println();
        
        return sum;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exercicio1");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        int position;
        
        do
        {
            position = IO.readint("Informe a posicao do termo: ");
            IO.println();
            
        } while (position < 1);
        
        IO.println("Termo = " + getSequenceTerm(position));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
