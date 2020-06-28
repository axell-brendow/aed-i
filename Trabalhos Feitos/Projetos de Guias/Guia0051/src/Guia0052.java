/*

PUC Minas - Ciencia da Computacao     Nome: Guia0052

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 14/03/2018

*/

import jkarel.Robot;
import jkarel.World;

import IO.*;

public class Guia0052 extends Robot
{
    /**
     * construtor padrao da classe Guia0052.
     *
     * @param avenue - uma das coordenadas da posicao inicial
     * @param street - outra das coordenadas da posicao inicial
     * @param direction - direcao inicial
     * @param beepers - quantidade inicial de marcadores
     */
    
    public Guia0052(int avenue, int street, int direction, int beepers)
    {
        
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
        
    } // end Guia0052( )

    /**
     * metodo para criar configuracoes do ambiente.
     *
     * @param nome do arquivo onde guardar a configuracao
     */
    
    public static void createWorld(String nome)
    {
        // o executor deste metodo (World - agente)
        // ja' foi definido na classe original (Robot)
        
        World.reset(); // limpar configuracoes
        
        // para nao exibir os passos de criacao do ambiente
        World.setTrace(false); // (opcional)
        
        /*
        
        parametros da funcao placeEWWall
        (
            int i = abscissa, (obs.: o centro da parede fica na abscissa)
            int i1 = ordenada, (obs.: a parede fica 0,5 unidades acima da ordenada)
            int i2 = tamanho da parede,
            int i3 = cores personalizadas
        )
        
        parametros da funcao placeNSWall
        (
            int i = abscissa, (obs.: a parede fica 0,5 unidades depois da abscissa)
            int i1 = ordenada, (obs.: o centro da parede fica na ordenada)
            int i2 = tamanho da parede,
            int i3 = cores personalizadas
        )
        
        */
        
        // criar paredes verticais
        
        World.placeNSWall(1, 3, 6);
        World.placeNSWall(2, 3, 5);
        World.placeNSWall(3, 5, 2);
        World.placeNSWall(4, 7, 1);
        World.placeNSWall(5, 6, 1);
        World.placeNSWall(6, 5, 1);
        World.placeNSWall(7, 3, 5);
        
        // criar paredes horizontais
        
        World.placeEWWall(2, 2, 6);
        World.placeEWWall(4, 4, 3);
        World.placeEWWall(6, 5, 1);
        World.placeEWWall(4, 6, 1);
        World.placeEWWall(5, 7, 3);
        World.placeEWWall(3, 7, 1);
        World.placeEWWall(2, 8, 6);
        
        // para colocar marcadores
        
        World.placeBeepers(6, 5, 1);
        World.placeBeepers(7, 3, 2);
        World.placeBeepers(2, 3, 3);
        
        // para guardar em arquivo
        World.saveWorld(nome); // gravar configuracao
        
    } // end createWorld( )

    /**
     * metodo para mover repetidas vezes.
     *
     * @param vezes para executar
     */
    
    public void moveN(int vezes)
    {
        // repetir (com teste no inicio)
        while (vezes > 0)
        {
            // mover-se uma vez ...
            move();
            
            // ... e descontar uma das ainda por fazer
            vezes = vezes - 1;
        } // end while
        
    } // end moveN( )
    
    /**
    * metodo para coletar marcadores.
    */
    
    public void pickBeepers( )
    {
        // repetir (com teste no inicio)
        // enquanto houver marcador proximo
        while ( nextToABeeper( ) )
        {
            // coletar um marcador
            pickBeeper ( );           
        } // end while
        
    } // end pickBeepers( )
    
    /**
     * coloca uma quantidade definida de marcadores na posicao atual
     * @param n numero de marcadores a colocar
     */
    
    public void putBeepers(int n)
    {
        if (n > 0 && anyBeepersInBeeperBag())
        {
            putBeeper();
            
            putBeepers(n - 1);
        }
    }
    
    /**
     * Move um numero de vezes e vira para alguma direcao em relacao a tela no final
     * @param numberOfMoves numero de vezes para mover
     * @param directionToTurnOnEnd direcao para olhar no final
     */
    
    public void moveAndTurn(int numberOfMoves, int directionToTurnOnEnd)
    {
        moveN(numberOfMoves); // anda um numero de vezes
        
        switch (directionToTurnOnEnd)
        {
            case NORTH:
                
                while (!facingNorth()) // virar a esquerda ate olhar para cima
                {
                    turnLeft();
                }
                
                break;
                
            case SOUTH:
                
                while (!facingSouth()) // virar a esquerda ate olhar para baixo
                {
                    turnLeft();
                }
                
                break;
                
            case EAST:

                while (!facingEast()) // virar a esquerda ate olhar para a direita
                {
                    turnLeft();
                }
                
                break;
            
            case WEST:

                while (!facingWest()) // virar a esquerda ate olhar para a esquerda
                {
                    turnLeft();
                }
                
                break;
                
            default:
                break;
        }
    }
    
    /**
     * Analisa qual direcao esta na mensagem
     * @param message direcao a ser analisada
     * @return inteiro correspondente da direcao
     */
    
    public int checkDirection(String message)
    {
        String[] directions = {"EAST", "NORTH", "WEST", "SOUTH"};
        
        for (int i = 0; i < directions.length; i++)
        {
            if (message.equals(directions[i]))
            {
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Traduz os comandos de um arquivo txt e os executa
     */
    
    public void translateAndExecute()
    {
        FILE comandos = new FILE(FILE.INPUT, "Tarefa0052.txt");
        
        String currentLine = comandos.readln();
        
        while (!comandos.eof())
        {
            // checa se a linha atual esta vazia ou 'e um comentario
            if (currentLine.equals("") || currentLine.substring(0, 2).equals("//"))
            {
                currentLine = comandos.readln(); // le a proxima linha
                continue; // pula para a proxima "iteracao"
            }
            
            int semicolonIndex = currentLine.indexOf(';');
            int firstCommaIndex = currentLine.indexOf(',');
            int secondCommaIndex;
            int firstParenthesisIndex = currentLine.indexOf('(');
            int secondParenthesisIndex = currentLine.indexOf(')');

            // obter todo o texto do chamado da funcao, ex: "goPickAndBack(5, EAST)"
            String fullFunctionText = currentLine.substring(0, semicolonIndex);
            
            // obter o texto do chamado da funcao ate o primeiro parentesis
            String functionName = fullFunctionText.substring(0, firstParenthesisIndex);
            
            IO.println(fullFunctionText); // imprimir cada acao

            String cut1, cut2, cut3;

            switch (functionName)
            {
                case "moveAndTurn":
                    // pega o primeiro parametro da funcao
                    cut1 = fullFunctionText.substring(firstParenthesisIndex + 1, firstCommaIndex);

                    // pega o segundo parametro da funcao (directionToTurnOnEnd)
                    cut2 = fullFunctionText.substring(firstCommaIndex + 2, secondParenthesisIndex);

                    moveAndTurn(IO.getint(cut1), checkDirection(cut2));

                    break;

                case "putBeepers":
                    // pega o primeiro parametro da funcao
                    cut1 = fullFunctionText.substring(firstParenthesisIndex + 1, secondParenthesisIndex);

                    putBeepers(IO.getint(cut1));

                    break;

                case "pickBeepers":
                    pickBeepers();
                    break;

                default:
                    break;
            }
            
            currentLine = comandos.readln(); // le a proxima linha
        }
        
        comandos.close();
    }
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Guia0052");
        IO.println("Autor: Axell Brendow                  Versao:  15.0\n");
        
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0052.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0052.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0052 JK = new Guia0052(1, 1, EAST, 0);
        
        JK.translateAndExecute(); // faz os movimentos necessarios do exercicio
        JK.turnOff(); // desliga o robo no final
        
    } // end main( )
    
} // end class