/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 23/03/2018

*/

import IO.*;

public class E2
{
    public static void showArrayElements(String[] array)
    {
        IO.print("Arranjo: ");
        
        for (String word : array)
        {
            IO.print(word + " ");
        }
        
        IO.print("palavras");
        IO.println();
    }
    
    /**
     * Percorre um arquivo buscando palavras que comecem com 'a' ou 'A'
     * @param fileName nome do arquivo
     * @return arranjo com as palavras na condicao
     */
    
    public static String[] getAStartingWords(String fileName)
    {
        String[] AStartingWords = new String[11];
        int numberOfWords = 0;
        char c;
        
        FILE file = new FILE(FILE.INPUT, fileName);
        String line = file.readln();
        String[] splitedLine;
        
        while (!file.eof() && line != null && numberOfWords < 10)
        {
            /**
             * No pdf ed08 nao foi informado se o arquivo PALAVRAS.TXT tera'
             * as palavras separadas por linha ou se estarao todas numa mesma
             * linha. Entao tentei me prevenir de alguma forma para o caso
             * de as palavras estarem numa mesma linha.
             */
            
            // presumo que se existir uma virgula na linha, as palavras estarao
            // separadas por virgulas
            if (line.contains(","))
            {
                splitedLine = line.split(",");
            }
            
            // caso haja espacos na linha, talvez, as palavras estarao separadas
            // por espacos em branco
            else if (line.contains(" "))
            {
                splitedLine = line.split(" ");
            }
            
            // caso em que as palavras estarao separadas por linhas
            else
            {
                splitedLine = new String[1];
                splitedLine[0] = line;
            }
            
            for (String word : splitedLine)
            {
                c = word.charAt(0); // pega o primeiro caractere da palavra
                
                if (c == 'a' || c == 'A') // checa se e' um a minusculo ou maiusculo
                {
                    AStartingWords[numberOfWords] = word; // adiciona a palavra
                    numberOfWords++; // aumenta o numero de palavras nessa condicao
                }
            }
            
            line = file.readln(); // le a proxima linha do arquivo
        }
        
        // adiciona quantas palavras foram encontradas no ultimo espaco do arranjo
        AStartingWords[10] = "" + numberOfWords;
        
        return AStartingWords;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String[] array;
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        array = getAStartingWords("PALAVRAS.TXT");
        
        if (IO.getint(array[10]) == 10) // checa se ha' 10 palavras
        {
            showArrayElements(array);
        }
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
