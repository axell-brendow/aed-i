import java.io.IOException;

/*

PUC Minas - Ciencia da Computacao     Nome: Exercicio1 - Refacao2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/04/2018

*/

public class Exercicio1
{
    /**
     * Funcao que checa se um caractere e' ou nao binario { 0, 1 }
     * @param digit caractere a ser analisado
     * @return 1 se for binario, 0 se nao
     */
    
    public static int isBinaryDigit(char digit)
    {
        return digit == '0' || digit == '1' ? 1 : 0;
    }
    
    /**
     * Funcao que checa se uma String representa um numero binario
     * @param str String a ser analisada
     * @return true se for, caso contrario, false
     */
    
    public static boolean isBinaryString(String str)
    {
        if (str == null || str.length() == 0) return false;
        
        boolean isBinaryString = true;
        
        for (int i = 0; i < str.length() && isBinaryString; i++)
        {
            isBinaryString = isBinaryDigit(str.charAt(i)) == 1;
        }
        
        return isBinaryString;
    }
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exercicio1 - Refacao2");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        int numberOfBinaryStrings = 0;
        String input;
        
        do
        {
            input = AxellIO.readString("Informe uma cadeia: ");
            
            if (isBinaryString(input))
            {
                numberOfBinaryStrings++;
            }
            
        } while (!input.equals("xxxx"));
        
        AxellIO.pause("\nQuantidade de numeros binarios: " + numberOfBinaryStrings);
    }
    
}
