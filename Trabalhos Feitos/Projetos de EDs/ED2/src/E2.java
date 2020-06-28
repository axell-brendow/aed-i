/*

PUC Minas - Ciencia da Computacao     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 17/03/2018

*/

import IO.*;

public class E2
{
    /**
     * Checa se um numero esta no intervalo [-15, 35]
     * @param number numero a checar
     * @return Valor logico de "numero esta no intervalo [-15, 35]"
     */
    
    public static boolean isOnInterval(double number)
    {
        return (number >= -15 && number <= 35);
    }
    
    /**
     * Checa o resto da divisao por dois
     * @param number numero a se dividir
     * @param desiredRest resto que se deseja encontrar
     * @return se resto e' o desejado ou nao
     */
    
    public static boolean checkRestOfDivisionByTwo(int number, int desiredRest)
    {
        return (Math.abs(number) % 2 == desiredRest);
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        // guardara' o numero de vezes que o usuario informara' dois numeros reais
        int numberOfProcesses;
        double value1, value2; // guardarao cada uma das duas entradas do usuario
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            numberOfProcesses = IO.readint("Informe a quantidade de vezes que informara' dois numeros reais: ");
            IO.println();
            
        } while(numberOfProcesses < 1);
        
        IO.println("Lembre-se de usar um ponto (.) para separar a parte inteira da parte decimal\nExemplo: 1/2 = 0.5\n");
        
        for (int i = 0; i < numberOfProcesses; i++)
        {
            IO.println("-----------------------\n");
            
            value1 = IO.readdouble("Informe o primeiro valor real: ");
            IO.println();
            
            value2 = IO.readdouble("Informe o segundo valor real: ");
            IO.println();
            
            /*
            Seguirei o mesmo padrao do programa Exemplo0032.java
            Vou mostrar uma mensagem quando a funcao IO.readint() retornar 0
            */
            
            if (value1 == 0 || value2 == 0)
            {
                IO.println("Algum valor informado e' nulo ou nao e' um numero\n");
            }
            
            // checa se o primeiro e o segundo valor nao estao no intervalo [-15, 35],
            // sao diferentes, suas partes inteiras nao sao pares e se o segundo e'
            // maior que o primeiro
            else if (
                    !isOnInterval(value1) && !checkRestOfDivisionByTwo((int) value1, 0) && value1 != value2 &&
                    !isOnInterval(value2) && !checkRestOfDivisionByTwo((int) value2, 0) && value2 > value1
                    )
            {
                IO.println(value1 + " e " + value2 + " nao estao no intervalo [-15, 35], sao diferentes,");
                IO.println("suas partes inteiras nao sao pares e o segundo e' maior que o primeiro\n");
            }
        }
        
        IO.pause("\n-----------------------\n\nPressione ENTER para finalizar");
    }
    
}
