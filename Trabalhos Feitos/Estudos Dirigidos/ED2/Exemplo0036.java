/*

PUC Minas - Ciencia da Computacao     Nome: Exemplo0036

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 17/03/2018

*/

import IO.*;

public class Exemplo0036
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        // guardara' o numero de vezes que o usuario informara' dois numeros inteiros
        int numberOfProcesses;
        int value1, value2; // guardarao cada uma das duas entradas do usuario
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0036");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfProcesses = IO.readint("Informe a quantidade de vezes que informara' dois numeros inteiros: ");
            IO.println();
            
        } while(numberOfProcesses < 1);
        
        for (int i = 0; i < numberOfProcesses; i++)
        {
            IO.println("-----------------------\n");
            
            value1 = IO.readint("Informe o primeiro valor inteiro: ");
            IO.println();
            
            value2 = IO.readint("Informe o segundo valor inteiro: ");
            IO.println();
            
            /*
            Seguirei o mesmo padrao do programa Exemplo0032.java
            Vou mostrar uma mensagem quando a funcao IO.readint() retornar 0
            */
            
            if (value1 == 0 || value2 == 0)
            {
                IO.println("Algum valor informado e' nulo ou decimal ou nao e' um numero\n");
            }
            
            // caso em que o primeiro e' positivo e menor que o segundo
            else if (value1 > 0 && value1 < value2) 
            {
                IO.println("O valor " + value1 + " e' positivo e menor que e o valor " + value2 + "\n");
            }
        }
        
        IO.pause("\n-----------------------\n\nPressione ENTER para finalizar");
    }
    
}
