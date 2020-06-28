/*

PUC Minas - Ciencia da Computacao     Nome: Exercicio3 - Refacao2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 18/04/2018

*/

import java.io.IOException;
import IO.FILE;

public class Exercicio3
{
    
    public static void main(String[] args) throws IOException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: Exercicio3 - Refacao2");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        FILE fileI = new FILE(FILE.INPUT, "PALAVRAS.TXT");
        FILE fileO = new FILE(FILE.OUTPUT, "SEMANA.TXT");
        String line = fileI.readln();
        
        String[] week = { "domingo", "segunda feira", "terca feira", "quarta feira", "quinta feira", "sexta feira", "sabado" };
        
        int numberOfWeekWords = 0;
        boolean isWeekWord;
        
        while (!fileI.eof() && line != null)
        {
            isWeekWord = false;
            
            for (int i = 0; i < week.length && !isWeekWord; i++)
            {
                isWeekWord = line.compareTo(week[i]) == 0;
            }
            
            if (isWeekWord)
            {
                numberOfWeekWords++;
                fileO.println(line);
            }
            
            line = fileI.readln();
        }
        
        AxellIO.pause("\nQuantidade de dias da semana encontrados: " + numberOfWeekWords);
    }
    
}
