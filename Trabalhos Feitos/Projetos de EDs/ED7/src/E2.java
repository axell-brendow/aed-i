/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 21/03/2018

*/

import IO.*;

public class E2
{
    /**
     * Em um arquivo com palavras separadas por linhas,
     * obtem quantas palavras comecam com 'a' ou 'A'
     * @param fileName nome do arquivo a se analisar
     * @return numero de palavras que comecam com 'a' ou 'A'
     */
    
    public static int getNumberOfAStartingWords(String fileName)
    {
        int numberOfAStartingWords = 0; // numero de palavras na condicao
        
        FILE file = new FILE(FILE.INPUT, fileName); // arquivo a se analisar
        
        String line = file.readln();
        
        char firstChar; // guardara' o primeiro caractere de cada linha
        
        while (!file.eof())
        {
            firstChar = line.charAt(0); // pega caractere no indice 0
            
            if (firstChar == 'a' || firstChar == 'A') // checa se e' a ou A
            {
                numberOfAStartingWords++; // aumenta 1 na quantidade de aAs
            }
            
            line = file.readln();
        }
        
        file.close(); // fecha o arquivo
        
        return numberOfAStartingWords;
    }
    
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args)
    {
        String fileName = "E2.txt";
        String[] words = {"abelha", "Aviao", "Defesa", "Ataque", "Coordenada", "Avanco", "aversao"};
        
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        FILE file = new FILE(FILE.OUTPUT, fileName); // cria arquivo para gravacao
        
        for (String word : words) // percorre a lista de palavras
        {
            file.println(word); // adiciona cada palavra e uma nova linha
        }
        
        file.close(); // fecha e salva os dados
        
        IO.println("Numero de palavras que comecam com a ou A: " + getNumberOfAStartingWords(fileName));
        
        IO.pause("\nPressione ENTER para terminar");
    }
    
}
