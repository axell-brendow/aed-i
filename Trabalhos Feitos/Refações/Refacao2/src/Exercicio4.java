/*

PUC Minas - Ciencia da Computacao     Nome: Exercicio4 - Refacao2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/04/2018

*/

import IO.IO;

public class Exercicio4
{
    // de acordo com o codigo da funcao, percebe-se que n e' a variavel que limita
    // quantas vezes a funcao recursiva deve rodar. r e' uma variavel que faz o
    // valor de x incrimentar ou nao 3 unidades e s representa cada termo da sequencia
    // logica porem com uma unidade a menos.
    
    public static int function_01(int n, boolean r, int s)
    {
        int x = 5; // inicia x com valor 5
        
        if (n > 0) // checa se a funcao recursiva ja' rodou quantas vezes era necessario
        {
            IO.print("+" + (s + 1)); // mostra um valor superior uma unidade a s
            
            x = s + 1; // essas duas linhas basicamente descartam
            s = x; // o valor 5 de x e fazem um "s++"
            
            // o valor de r alterna a cada chamada de function_01(), portanto,
            // na primeira chamada, em que r = false, x tera' seu valor incrimentado
            // em 3 unidades, depois, nao tera' incrimento, depois, +3, e assim por diante
            if (!r) { x = x + 3; }
            
            // chama outra function_01() passando x como o proximo "termo da sequencia - 1"
            x = s + function_01(n - 1, !r, x);
        }
        
        else // quando nao haver mais termos para calcular,
        {
            x = 0; // atribui o valor 0 'a soma dos termos dessa function_01()
            IO.println();
        }
        
        // x representara' a soma dos termos da sequencia logica a partir do
        // termo que a function_01() atual esta' calculando
        return x;
    }
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exercicio4 - Refacao2");
        AxellIO.println("Autor: Theldo                         Versao:  1.0\n");
        
        int n = 5;
        
        IO.println("Question 04");
        IO.println("f(" + n + ") = " + function_01(n, n == 0, 0));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
