import java.io.IOException;

/*

PUC Minas - Ciencia da Computacao     Nome: Exercicio2 - Refacao2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/04/2018

*/

public class Exercicio2
{
    
    public static int lowerDifference(Integer[] values)
    {
        if (values == null || values.length < 3) return 0;
        
        // possibilidades de diferenca entre os valores
        int[] differences = { values[0] - values[1], values[0] - values[2], values[1] - values[2] };
        int lowerDifference = Math.abs(differences[0]); // primeira possibilidade
        int lowerDifference1; // guardara' a proxima possiblidade
        
        for (int i = 1; i < differences.length; i++) // percorre as possibilidades
        {
            lowerDifference1 = Math.abs(differences[i]); // pega a proxima possibilidade
            
            // checa se essa nova possibilidade e' menor que a atual menor possibilidade
            if (lowerDifference1 < lowerDifference)
            {
                // se for, muda a atual para a nova
                lowerDifference = lowerDifference1;
            }
        }
        
        return lowerDifference; // retorna a menor diferenca
    }
    
    public static void moveToLeft(Integer[] array)
    {
        if (array == null || array.length < 2) return;
        
        // percorre o arranjo a partir da segunda posicao
        for (int i = 1; i < array.length; i++)
        {
            // no espaco do elemento anterior, coloca o elemento atual
            array[i - 1] = array[i];
        }
    }
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exercicio2 - Refacao2");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        Integer[] values = new Integer[3]; // cria um arranjo para guardar os valores
        double soma = 0; // guardara' a soma dos quadrados dos inversos
        Integer element; // guardara' cada novo valor
        
        for (int i = 0; i < 3; i++)
        {
            do
            {
                values[i] = AxellIO.readInt("Informe um valor: ");
                
            } while (values[i] == null); // fica em looping ate um inteiro ser informado
        }
        
        // se os tres valores forem iguais termina o programa
        if ((values[0] + values[1] + values[2] == values[0] * 3)) return;
        
        int lD = lowerDifference(values);
        
        // se a menor diferenca entre os 3 valores for 0, evita a divisao
        // " 1.0 / 0 " simplesmente nao alterando o valor da soma (somando 0)
        soma += lD == 0 ? 0 : Math.pow(1.0 / lowerDifference(values), 2);
        
        // fica em looping ate' que os tres numeros sejam diferentes
        while (values[0] + values[1] + values[2] != values[0] * 3)
        {
            do
            {
                element = AxellIO.readInt("Informe um valor: ");
                
            } while (element == null); // fica em looping ate um inteiro ser informado
            
            // move os valores do arranjo para a esquerda. O ultimo valor fica duplicado no final
            moveToLeft(values);
            values[2] = element; // substitui o ultimo valor pelo novo
            
            lD = lowerDifference(values);
            
            // se a menor diferenca entre os 3 valores for 0, evita a divisao
            // " 1.0 / 0 " simplesmente nao alterando o valor da soma (somando 0)
            soma += lD == 0 ? 0 : Math.pow(1.0 / lD, 2);
        }
        
        AxellIO.pause("Soma dos inversos dos quadrados das menores diferencas entre cada tres valores: " + soma);
    }
    
}
