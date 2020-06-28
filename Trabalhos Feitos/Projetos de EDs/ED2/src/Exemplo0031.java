/*

PUC Minas - Ciencia da Computacao     Nome: Exemplo0031

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 17/03/2018

*/

import IO.*;

public class Exemplo0031
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfValues; // guardara o numero de entradas que o usuario informar
        int value; // guardara cada entrada do usuario
        final String message = "O valor informado e' ";
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0031");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfValues = IO.readint("Informe a quantidade de valores inteiros: ");
            IO.println();
            
        } while(numberOfValues < 1);
        
        for (int i = 0; i < numberOfValues; i++)
        {
            IO.println("-----------------------\n");
            
            value = IO.readint("Informe um valor inteiro: ");
            IO.println();
            
            // caso em que o valor e' zero ou decimal ou nao e' um numero
            if (value == 0)
            {
                IO.println(message + "nulo ou decimal ou nao e' um numero\n");
            }
            
            else if (value > 0) // caso em que o valor e' positivo
            {
                IO.println(message + "positivo\n");
            }
            
            else if (value < 0) // caso em que o valor e' negativo
            {
                IO.println(message + "negativo\n");
            }
        }
        
        IO.pause("\n-----------------------\n\nPressione ENTER para finalizar");
    }
    
}
