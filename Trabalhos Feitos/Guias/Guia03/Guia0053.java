/*

PUC Minas - Ciencia da Computacao     Nome: Guia0053

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 14/03/2018

*/

import jkarel.Robot;
import jkarel.World;

import IO.*;

public class Guia0053 extends Robot
{
    /**
     * construtor padrao da classe Guia0053.
     *
     * @param avenue - uma das coordenadas da posicao inicial
     * @param street - outra das coordenadas da posicao inicial
     * @param direction - direcao inicial
     * @param beepers - quantidade inicial de marcadores
     */
    
    public Guia0053(int avenue, int street, int direction, int beepers)
    {
        
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
        
    } // end Guia0053( )

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
        
        // criar paredes horizontais
        
        World.placeEWWall(2, 2, 6);
        World.placeEWWall(5, 4, 2);
        World.placeEWWall(6, 6, 1);
        World.placeEWWall(4, 6, 1);
        World.placeEWWall(3, 7, 5);
        World.placeEWWall(2, 8, 6);
        
        // para colocar marcadores
        
        World.placeBeepers(4, 7, 1);
        World.placeBeepers(5, 7, 2);
        World.placeBeepers(6, 7, 3);
        
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
        /*
        Lembrete pessoal: Em FILE.OUTPUT e FILE.INPUT, as palavras "INPUT" e
        "OUTPUT" são relacionadas a saida e entrada de dados na memoria e
        nao no arquivo, portanto, INPUT significa a entrada de dados na memoria
        e OUTPUT a saida de dados da memoria
        */
        
        FILE tabelaDeBeepers = new FILE(FILE.APPEND, "Tarefa0053b.txt");
        int numberOfBeepers = 0;
        
        // repetir (com teste no inicio)
        // enquanto houver marcador proximo
        while ( nextToABeeper( ) )
        {
            // coletar um marcador
            pickBeeper ( );
            numberOfBeepers++;
        } // end while
        
        tabelaDeBeepers.println(numberOfBeepers + " marcador" + (numberOfBeepers > 1 ? "es" : "") + " na posicao (" + avenue() + ", " + street() + ")");
        tabelaDeBeepers.close();
    } // end pickBeepers( )
    
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
    
    public void doTask()
    {
        moveAndTurn(7, NORTH);
        moveAndTurn(7, WEST);
        moveAndTurn(1, -1);
        
        while (!(avenue() == 8 && street() == 8))
        {
            while (nextToABeeper()) pickBeeper();
            
            if (leftIsClear())
            {
                turnLeft();
                moveN(1);
            }
            
            else if (frontIsClear())
            {
                moveN(1);
            }
            
            else if (rightIsClear())
            {
                turnLeft();
                turnLeft();
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
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Guia0053");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0053.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0053.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0053 JK = new Guia0053(1, 1, EAST, 0);
        
        JK.doTask();
        JK.turnOff(); // desliga o robo no final
        
    } // end main( )
    
} // end class