/*

PUC Minas - Ciencia da Computacao     Nome: E1

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 14/03/2018

*/

import jkarel.Robot;
import jkarel.World;

import IO.*;

public class E1 extends Robot
{
    /**
     * construtor padrao da classe E1.
     *
     * @param avenue - uma das coordenadas da posicao inicial
     * @param street - outra das coordenadas da posicao inicial
     * @param direction - direcao inicial
     * @param beepers - quantidade inicial de marcadores
     */
    
    public E1(int avenue, int street, int direction, int beepers)
    {
        
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
        
    } // end E1( )

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
        
        World.placeNSWall(1, 5, 2);
        World.placeNSWall(8, 5, 2);
        
        // criar paredes horizontais
        
        World.placeEWWall(2, 4, 7);
        World.placeEWWall(2, 5, 3);
        World.placeEWWall(6, 5, 3);
        World.placeEWWall(2, 6, 7);
        
        // para colocar marcadores
        
        World.placeBeepers(2, 5, 1);
        
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
     * Faz o robo andar sempre que possivel para a direita
     * ate alguma posicao onde ele deva parar
     * @param avenueToStop coordenada "x" de parada
     * @param streetToStop coordenada "y" de parada
     */
    
    public void halfPathRight(int avenueToStop, int streetToStop)
    {
        do
        {
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
        } while (!(avenue() == avenueToStop && street() == streetToStop));
    }
    
    /**
     * Faz o robo andar sempre que possivel para a esquerda
     * ate alguma posicao onde ele deva parar
     * @param avenueToStop coordenada "x" de parada
     * @param streetToStop coordenada "y" de parada
     */
    
    public void halfPathLeft(int avenueToStop, int streetToStop)
    {
        do
        {
            if (leftIsClear())
            {
                turnLeft();
                move();
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
                move();
            }
            
            else
            {
                turnLeft();
                turnLeft();
            }
        } while (!(avenue() == avenueToStop && street() == streetToStop));
    }
    
    /**
     * Gerencia a movimentacao de dois robos
     * @param robot1 primeiro robo
     * @param robot2 segundo robo
     */
    
    public static void doTask(E1 robot1, E1 robot2)
    {
        task1 task1 = new task1(1, 1, EAST, 0);
        task2 task2 = new task2(1, 1, EAST, 0);
        task3 task3 = new task3(1, 1, EAST, 0);
        task4 task4 = new task4(1, 1, EAST, 0);
        
        task1.remove();
        task2.remove();
        task3.remove();
        task4.remove();
        
        task1.goAndGetTheBeeper(robot1); // robo1 pega o marcador
        
        task2.goToDeliveryPoint(robot2); // robo2 vai ao ponto de entrega
        
        task2.goToDeliveryPoint(robot1); // robo1 vai ao ponto de entrega
        
        if (robot1.nextToARobot()) // checa se robo1 esta perto de outro robo
        {
            robot1.putBeeper(); // robo1 deixa o marcador
            
            if (robot2.nextToABeeper()) // robo2 checa se esta perto de algum marcador
            {
                robot2.pickBeeper(); // robo2 pega o marcador
            }
            
            // robo2 poe o marcador na posicao inicial de robo1
            task3.putBeeperOnRobot1Home(robot2);

            task4.goHome(8, 6, WEST, robot2); // robo2 vai para a sua posicao inicial
            task4.goHome(2, 6, EAST, robot1); // robo1 vai para a sua posicao inicial
        }
        
        else // caso em que o robo2 nao chegou ao ponto de entrega
        {
            task4.goHome(2, 6, EAST, robot1); // robo1 vai para a sua posicao inicial
        }
    }
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: E1");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("E1.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("E1.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        E1 robot1 = new E1(2, 6, EAST, 0);
        E1 robot2 = new E1(8, 6, WEST, 0);
        
        doTask(robot1, robot2);
        
        robot1.turnOff();
        robot2.turnOff();
    } // end main( )
    
} // end class