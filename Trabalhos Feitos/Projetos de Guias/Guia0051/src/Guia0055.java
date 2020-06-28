/*

PUC Minas - Ciencia da Computacao     Nome: Guia0055

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 14/03/2018

*/

import jkarel.Robot;
import jkarel.World;

import IO.*;

public class Guia0055 extends Robot
{
    /**
     * construtor padrao da classe Guia0055.
     *
     * @param avenue - uma das coordenadas da posicao inicial
     * @param street - outra das coordenadas da posicao inicial
     * @param direction - direcao inicial
     * @param beepers - quantidade inicial de marcadores
     */
    
    public Guia0055(int avenue, int street, int direction, int beepers)
    {
        
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
        
    } // end Guia0055( )

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
     * Faz o robo andar sempre que possivel para a direita ate alguma posicao onde ele deva parar
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
     * Faz o robo andar sempre que possivel para a esquerda ate alguma posicao onde ele deva parar
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
     * Leva o robo ate o marcador e o pega
     */
    
    public void goAndGetTheBeeper()
    {
        halfPathRight(2, 5);
        pickBeeper();
    }
    
    /**
     * Leva o robo ate o ponto de entrega
     */
    
    public void goToDeliveryPoint()
    {
        halfPathRight(5, 6);
    }
    
    /**
     * Vai ate a posicao inicial do robo1 e deixa o marcador
     */
    
    public void putBeeperOnRobot1Home()
    {
        halfPathRight(2, 6);
        putBeeper(); // o robo2 poe o marcador na posicao inicial do robo1
    }
    
    /**
     * leva o robo ate sua posicao inicial e gira-o para a direcao
     * em que estava olhando no inicio
     * @param avenue avenida em que ele deve parar
     * @param street rua em que ele deve parar
     * @param directionToTurnOnEnd direcao para virar no final do processo
     */
    
    public void goHome(int avenue, int street, int directionToTurnOnEnd)
    {
        halfPathLeft(avenue, street);
        moveAndTurn(0, directionToTurnOnEnd);
    }
    
    /**
     * Gerencia a movimentacao de dois robos
     * @param robot1 primeiro robo
     * @param robot2 segundo robo
     */
    
    public static void doTask(Guia0055 robot1, Guia0055 robot2)
    {
        robot1.goAndGetTheBeeper();
        robot2.goToDeliveryPoint();
        
        robot1.goToDeliveryPoint();
        
        if (robot1.nextToARobot()) // checa se robo1 esta perto de outro robo
        {
            robot1.putBeeper(); // robo1 deixa o marcador
            
            if (robot2.nextToABeeper()) // robo2 checa se esta perto de algum marcador
            {
                robot2.pickBeeper(); // robo2 pega o marcador
            }
            
            robot2.putBeeperOnRobot1Home();
            
            /*
            A partir desse ponto nao entendi o que o exercicio pede, pois na parte
            escrita informa-se que os robos devem voltar as posicoes iniciais, mas,
            no grafico do pdf "guia03" no Guia0055, o desenho final mostra os robos R1 e R2
            em andares diferentes dos seus andares iniciais e ainda estao em lados opostos.
            Por exemplo, no grafico inicial, o robo 1 estava no andar de cima na parte
            da esquerda. No grafico final, ele aparece no andar de baixo na parte da direita.
            Mas considerarei a parte escrita.
            */

            robot2.goHome(8, 6, WEST); // robo2 vai para a sua posicao inicial
            robot1.goHome(2, 6, EAST); // robo1 vai para a sua posicao inicial
        }
        
        else // caso em que o robo2 nao chegou ao ponto de entrega
        {
            robot1.goHome(2, 6, EAST); // volta para a posicao inicial
        }
    }
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Guia0055");
        IO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0055.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0055.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0055 robot1 = new Guia0055(2, 6, EAST, 0);
        Guia0055 robot2 = new Guia0055(8, 6, WEST, 0);
        
        doTask(robot1, robot2);
        
        robot1.turnOff();
        robot2.turnOff();
    } // end main( )
    
} // end class