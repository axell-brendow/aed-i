/*

PUC Minas - Ciencia da Computacao     Nome: E1

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 12/03/2018

*/

import IO.*;

public class E1
{
    /**
     * Conta a quantidade de comandos de um arquivo .txt
     * @param fileName nome do arquivo para contar os comandos
     * @return quantidade de comandos
     */
    
    public static int countCommands(String fileName)
    {
        int numberOfCommands = 0;
        
        FILE comandos = new FILE(FILE.INPUT, fileName);
        
        String currentLine = comandos.readln();
        
        while (!comandos.eof())
        {
            // checa se a linha atual esta vazia ou 'e um comentario
            if (currentLine.equals("") || currentLine.substring(0, 2).equals("//"))
            {
                currentLine = comandos.readln(); // le a proxima linha
                continue; // pula para a proxima "iteracao"
            }
            
            numberOfCommands++;
            currentLine = comandos.readln(); // le a proxima linha
        }
        
        comandos.close();
        
        return numberOfCommands;
    }
    
    public static void showNumberOfCommands(String fileName)
    {
        int numberOfCommands = countCommands(fileName);
        
        IO.println("Numero de comandos do arquivo " + fileName + ": " + numberOfCommands);
    }
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E1 - Guia02");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        showNumberOfCommands("Tarefa0035.txt");
        IO.println();
        
        IO.pause("Pressione ENTER para terminar");
        
    } // end main( )
    
} // end class

/*

---------- testes

Versao  Teste
1.0     01. ( OK )   teste inicial
2.0     01. ( OK )   teste da repeticao para virar a direita
3.0     01. ( OK )   teste da repeticao para percorrer um quadrado
4.0     01. ( OK )   teste do apanhar marcador
5.0     01. ( OK )   teste da contagem de Beepers
6.0     01. ( OK )   teste da movimentacao interativa
7.0     01. ( OK )   teste do metodo execute
8.0     01. ( OK )   teste de gravacao da sequencia de acoes
9.0     01. ( OK )   teste da leitura da sequencia de acoes
10.0     01. ( OK )   teste de traducao das acoes

*/