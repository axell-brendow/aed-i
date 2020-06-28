/*

PUC Minas - Ciencia da Computacao     Nome: Guia0054

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 14/03/2018

*/

import jkarel.Robot;
import jkarel.World;

import IO.*;

public class Guia0054 extends Robot
{
    static int N_AVENUES;
    static int N_STREETS;
    static char[][] traveledPath;
    
    /**
     * construtor padrao da classe Guia0054.
     *
     * @param avenue - uma das coordenadas da posicao inicial
     * @param street - outra das coordenadas da posicao inicial
     * @param direction - direcao inicial
     * @param beepers - quantidade inicial de marcadores
     */
    
    public Guia0054(int avenue, int street, int direction, int beepers)
    {
        
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
        
    } // end Guia0054( )

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
        World.placeNSWall(2, 4, 4);
        World.placeNSWall(3, 5, 2);
        World.placeNSWall(4, 7, 1);
        World.placeNSWall(5, 7, 1);
        World.placeNSWall(6, 5, 2);
        World.placeNSWall(7, 3, 5);
        World.placeNSWall(4, 5, 1);
        World.placeNSWall(5, 5, 1);
        
        // criar paredes horizontais
        
        World.placeEWWall(2, 2, 6);
        World.placeEWWall(5, 4, 1);
        World.placeEWWall(5, 5, 1);
        World.placeEWWall(6, 6, 1);
        World.placeEWWall(4, 6, 1);
        World.placeEWWall(3, 7, 5);
        World.placeEWWall(2, 8, 6);
        World.placeEWWall(3, 3, 1);
        
        // para colocar marcadores
        
        World.placeBeepers(6, 7, 1);
        World.placeBeepers(5, 6, 2);
        World.placeBeepers(4, 7, 3);
        
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
            
            // relacao entre a coordenada no mapa (x) e
            // a coordenada da matriz bidimensional (f(x)) e' f(x) = -x + 10
            
            traveledPath[-street() + 10][avenue() - 1] = 'X';
            
            // ... e descontar uma das ainda por fazer
            vezes = vezes - 1;
        } // end while
        
    } // end moveN( )
    
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
     * Faz o robo andar no mapa pegando os beepers por perto e usa as
     * funcoes de checagem de paredes ao redor para se movimentar
     */
    
    public void doTask()
    {
        moveAndTurn(7, NORTH);
        moveAndTurn(7, WEST);
        moveAndTurn(1, -1);
        
        while (!(avenue() == 8 && street() == 8))
        {
            while (nextToABeeper()) pickBeeper();
            
            if (rightIsClear())
            {
                turnLeft();
                turnLeft();
                turnLeft();
                moveN(1);
            }
            
            else if (frontIsClear())
            {
                moveN(1);
            }
            
            else if (leftIsClear())
            {
                turnLeft();
                moveN(1);
            }
            
            else
            {
                turnLeft();
                turnLeft();
            }
        }
        
        moveAndTurn(0, SOUTH);
        moveAndTurn(7, WEST);
        moveAndTurn(7, EAST);
    }
    
    public void showMap()
    {
        for (int i = 0; i < N_AVENUES; i++)
        {
            for (int j = 0; j < N_STREETS; j++)
            {
                IO.print(traveledPath[i][j] == '\u0000' ? (0 + " ") : "X ");
            }
            
            IO.println();
        }
    }
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Guia0054");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0054.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0054.txt"); // ler configuracao do ambiente
        
        N_AVENUES = World.numberOfAvenues();
        N_STREETS = World.numberOfStreets();
        traveledPath = new char[N_AVENUES][N_STREETS];
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0054 JK = new Guia0054(1, 1, EAST, 0);
        
        JK.doTask();
        JK.turnOff(); // desliga o robo no final
        JK.showMap();
        
    } // end main( )
    
} // end class