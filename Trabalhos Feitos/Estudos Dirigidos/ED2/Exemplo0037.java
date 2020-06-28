/*

PUC Minas - Ciencia da Computacao     Nome: Exemplo0037

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 17/03/2018

*/

import IO.*;

public class Exemplo0037
{
    /**
     * Checa se um numero esta no intervalo [-15, 35]
     * @param number numero a checar
     * @return Valor logico de "numero esta no intervalo [-15, 35]"
     */
    
    public static boolean isOnInterval(int number)
    {
        return (number >= -15 && number <= 35);
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        // guardara' o numero de vezes que o usuario informara' dois numeros inteiros
        int numberOfProcesses;
        int value1, value2; // guardarao cada uma das duas entradas do usuario
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0037");
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
            Seguirei o mesmo padrao dos exercicios anteriores mostrando uma
            mensagem quando a funcao IO.readint() retornar 0
            */
            
            if (value1 == 0 || value2 == 0)
            {
                IO.println("Algum valor informado e' nulo ou decimal ou nao e' um numero\n");
            }
            
            // checa se o primeiro e o segundo valor estao no intervalo [-15, 35]
            else if (isOnInterval(value1) && isOnInterval(value2))
            {
                IO.println("O valor " + value1 + " e o valor " + value2 + " estao no intervalo [-15, 35]\n");
            }
        }
        
        IO.pause("\n-----------------------\n\nPressione ENTER para finalizar");
    }
    
}
