/*

PUC Minas - Ciencia da Computacao     Nome: Exemplo0035

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 17/03/2018

*/

import IO.*;

public class Exemplo0035
{

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        /*
        Obs.: Demorei aproximadamente 30 minutos para conseguir entender o
        enunciado do exercicio 5. Acredito que nao valeu a pena, nesse caso,
        tentar dizer muito, digitando pouco. Quando li pela primeira vez, entendi
        que era para continuar fazendo o mesmo processo dos exercicios anteriores,
        porem apos o usuario informar o numero de vezes e entrar com os dados de cada uma,
        dever-se-ia pegar mais dois valores no final da repeticao. Nao consegui
        entender que o processo mudou, ou seja, antes, a "quantidade de vezes" representava
        o processo de pegar um numero do usuario por vez, agora, a "quantidade de vezes"
        representa o processo de pegar dois numeros do usuario por vez.
        E mesmo assim nao sei se essa era a interpretacao desejada.
        Acredito que digitando um pouco mais ou usando um ou dois pronomes demonstrativos
        a mais, ficaria mais claro.
        */
        
        // guardara' o numero de vezes que o usuario informara' dois numeros inteiros
        int numberOfProcesses;
        int value1, value2; // guardarao cada uma das duas entradas do usuario
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0035");
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
            
            // caso em que o primeiro e' par e o segundo e' impar
            else if (value1 % 2 == 0 && Math.abs(value2) % 2 == 1) 
            {
                IO.println("O valor " + value1 + " e' par e o valor " + value2 + " e' impar\n");
            }
        }
        
        IO.pause("\n-----------------------\n\nPressione ENTER para finalizar");
    }
    
}
