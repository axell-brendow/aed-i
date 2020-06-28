/*

PUC Minas - Ciência da Computação     Nome: Exemplo0118

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 19/03/2018

*/

import IO.*;

public class Exemplo0118
{
    /*
    Sei que nao era necessario para o exercicio, mas o custo da recursividade
    nesse caso e' altissimo, ate uma aberracao, entao quis deixar
    o processo mais rapido e mais leve com uso de uma array, mas, obviamente,
    nao deixei de usar a recursividade.
    
    Para achar, por exemplo, o decimo sexto numero par da sequencia sem o uso
    da array, demorou cerca de 45 segundos, com o uso dela, demorou apenas 1.
    Aparentemente, o programa ficou 45 vezes mais rapido, mas depois de perceber
    que o programa consegue chegar ao centesimo numero par tambem em 1 segundo,
    vi que a relacao e' infinitamente superior.
    
    Obs.: No sexagesimo primeiro numero par o limite da variavel long e' estourado
    */
    
    static long fibonacciSequence[]; // guardara' os termos que ja' foram encontrados da sequencia
    
    /**
     * Checa se o termo da sequencia ja' foi encontrado
     * @param position posicao no termo na sequencia
     * @return valor logico de "termo ja' existe"
     */
    
    public static boolean existTerm(int position)
    {
        return fibonacciSequence[position - 1] != 0;
    }
    
    /**
     * Percorre a sequencia Fibonacci para buscar um termo
     * @param position posicao do termo
     * @return termo na dada posicao
     */
    
    public static long getFibonnaciTerm(int position)
    {
        long term = 0L;
        
        if (position < 3) // para as posicoes 1 e 2 o termo e' 1
        {
            if (!existTerm(position)) // se nao existe o termo na array, adiciona-o
            {
                fibonacciSequence[position - 1] = 1L;
            }
            
            term = fibonacciSequence[position - 1];
        }
        else
        {
            if (!existTerm(position)) // se nao existe o termo na array, adiciona-o
            {
                fibonacciSequence[position - 1] = getFibonnaciTerm(position - 2) + getFibonnaciTerm(position - 1);
            }
            
            term = fibonacciSequence[position - 1];
            
        }
        
        return term;
    }
    
    /**
     * Checa os termos pares da sequencia
     * @param pairsToRun quantidade exata de pares a percorrer
     * @return o ultimo par encontrado
     */
    
    public static long getFibonacciPairNumber(int pairsToRun)
    {
        long pairTerm = 0L;
        int count = 1; // comeca pelo primeiro termo da sequencia
        
        while (pairsToRun > 0) // so' para quando percorre todos os pares
        {
            // vai checando se cada termo da sequencia e' par
            if (getFibonnaciTerm(count) % 2 == 0)
            {
                pairsToRun--; // diminui a quantidade de pares a percorrer
            }
            
            count++; // pula para o proximo termo da sequencia
        }
        
        pairTerm = getFibonnaciTerm(count - 1); // pega o ultimo termo percorrido
        
        return pairTerm;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int pairsToRun; // quantidade de pares a percorrer
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Exemplo0118");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            pairsToRun = IO.readint("Informe a quantidade de pares a percorrer: ");
            IO.println();
            
        } while (pairsToRun < 1);
        
        // Na sequencia Fibonnaci, a cada tres termos, tem-se um numero par:
        // 1, 1, 2*, 3, 5, 8*, 13, 21, 44*
        // Conclui-se isso observando a obtencao do quarto termo em diante, a ordem das somas sao:
        // impar(1) + par(2) = impar(3), depois, par(2) + impar(3) = impar(5), depois impar(3) + impar(5) = par(8),
        // apos isso, volta-se a somar impar(5) + par(8) = impar(13) ...
        
        // (pairsToRun * 3) e' exatamente a posicao do numero par que a pessoa deseja chegar.
        fibonacciSequence = new long[pairsToRun * 3];
        
        IO.println(pairsToRun + "o termo par: " + getFibonacciPairNumber(pairsToRun));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
