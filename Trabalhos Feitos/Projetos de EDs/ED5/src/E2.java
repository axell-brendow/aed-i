/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/03/2018

*/

import IO.*;

public class E2
{
    // f ( n ) = (1+2/3) * (1+3/4) * (1+4/5) * ...
    // se a variavel "number" tiver um valor maior que 25,
    // o resultado do produto sera em notacao cientifica
    
    public static double function(int number)
    {
        double product = 1, currentNumber;
        String process = "";
        
        for (int i = 0; i < number; i++) // percorre a quantidade de vezes
        {
            process += "(1 + " + (2 + i) + "/" + (3 + i) + ") * ";
            
            // obtem o numero atual da sequencia logica
            currentNumber = 1 + ((2.0 + i) / (3 + i));
            
            product *= currentNumber; // multiplica-o aos numeros anteriores da sequencia logica
        }
        
        // remove o ultimo " * " da expressao
        process = process.substring(0, process.length() - 3);
        
        IO.println(process);
        
        if (number > 25) // alerta o usuario da possibilidade de aparicao da notacao cientifica
        {
            IO.println("\nObs.: para quantidade de vezes maior que 25, o resultado saira' na\nforma de notacao cientifica. Ex: 2 . 10^7 sera' 2E7");
        }
        
        return product;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        int number;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        do
        {
            number = IO.readint("Informe a quantidade de vezes: ");
            IO.println();
            
        } while(number < 1);
        
        IO.println("\nProduto: " + function(number));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
