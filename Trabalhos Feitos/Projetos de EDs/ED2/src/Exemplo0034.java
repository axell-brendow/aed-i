/*

PUC Minas - Ciencia da Computacao     Nome: Exemplo0034

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 17/03/2018

*/

import IO.*;

public class Exemplo0034
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int numberOfValues; // guardara o numero de entradas que o usuario informar
        int value; // guardara cada entrada do usuario
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0034");
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
            
            /*
            Seguirei o mesmo padrao do programa Exemplo0032.java
            Vou mostrar uma mensagem quando a funcao IO.readint() retornar 0
            */
            
            if (value == 0)
            {
                IO.println("O valor informado e' nulo ou decimal ou nao e' um numero\n");
            }
            
            // caso em que o valor nao esta no intervalo [-15, 35]
            else if ( !(value >= -15 && value <= 35) ) 
            {
                IO.println(value + " nao esta no intervalo [-15, 35]\n");
            }
        }
        
        IO.pause("\n-----------------------\n\nPressione ENTER para finalizar");
    }
    
}
