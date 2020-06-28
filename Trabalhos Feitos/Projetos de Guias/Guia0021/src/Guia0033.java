/*

PUC Minas - Ciência da Computação     Nome: Guia0033

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  13.0                         Data: 12/03/2018

*/

import jkarel.Robot;
import jkarel.World;

import IO.*;

public class Guia0033 extends Robot
{

    /**
     * construtor padrao da classe Guia0033.
     *
     * @param avenue - uma das coordenadas da posicao inicial
     * @param street - outra das coordenadas da posicao inicial
     * @param direction - direcao inicial
     * @param beepers - quantidade inicial de marcadores
     */
    
    public Guia0033(int avenue, int street, int direction, int beepers)
    {
        
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
        
    } // end Guia0033( )

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
        
        World.placeNSWall(2, 3, 6);
        World.placeNSWall(3, 3, 5);
        World.placeNSWall(4, 3, 5);
        World.placeNSWall(5, 3, 6);
        
        // criar paredes horizontais
        
        World.placeEWWall(3, 2, 3);
        World.placeEWWall(3, 8, 1);
        World.placeEWWall(5, 8, 1);
        
        // para colocar marcadores
        
        World.placeBeepers(3, 3, 1);
        World.placeBeepers(4, 3, 2);
        World.placeBeepers(5, 3, 3);
        
        // para guardar em arquivo
        World.saveWorld(nome); // gravar configuracao
        
    } // end createWorld( )
    
    /**
     * metodo para virar 'a direita.
     */
    
    public void turnRight()
    {
        // definir dado local
        int vezes = 1; // para contar quantas vezes
        
        // o executor deste metodo
        // devera' virar tres vezes 'a esquerda
        // repetir (com teste no inicio)
        while ( vezes <= 3 )
        {
            // virar uma vez ...
            turnLeft( );
            
            // ... e contar mais uma feita
            vezes = vezes + 1;
        } // end while
        
    } // end turnRight( )

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
     * anda em uma direcao definida
     * @param step direcao
     */
    
    public void manageStep(char step)
    {
        /*
        'u' = up,
        'd' = down,
        'r' = right,
        'l' = left
        */
        
        switch (step)
        {
            case 'u':
                
                while (!facingNorth()) // virar a esquerda ate olhar para o norte
                {
                    turnLeft();
                }
                
                move();
                
                break;
                
            case 'd':
                
                while (!facingSouth()) // virar a esquerda ate olhar para o sul
                {
                    turnLeft();
                }
                
                move();
                
                break;
                
            case 'r':

                while (!facingEast()) // virar a esquerda ate olhar para o leste
                {
                    turnLeft();
                }
                
                move();
                
                break;
            
            case 'l':

                while (!facingWest()) // virar a esquerda ate olhar para o oeste
                {
                    turnLeft();
                }
                
                move();
                
                break;
                
            default:
                return;
        }
    }
    
    public void goPickAndBack()
    {
        moveN(5);
        pickBeepers();
        
        manageStep('u'); // vira para cima e anda um passo
        moveN(4);
    }
    
    /**
    *  metodo para mover o robo
    */
    
    public void doTask()
    {
        
        move();
        turnLeft();
        
        moveN(8);
        turnRight();
        
        moveN(2);
        turnRight();
        
        move();
        turnRight();
        
        move();
        turnLeft();
        
        goPickAndBack();
        turnRight();
        
        move();
        turnRight();
        
        goPickAndBack();
        turnRight();
        
        move();
        turnRight();
        
        goPickAndBack();
        turnLeft();
        
        move();
        turnRight();
        
        move();
        turnRight();
        
        moveN(5);
        turnRight();
        
        moveN(8);
        putBeepers(6);
        turnRight();
        
        moveN(8);
        
        while(!facingEast()) turnLeft(); // vira para leste
        
    }
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Guia0033");
        IO.println("Autor: Axell Brendow                  Versao:  13.0\n");
        
        // criar o ambiente com escada
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0033.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0033.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0033 JK = new Guia0033(1, 1, EAST, 0);
        
        JK.doTask(); // faz os movimentos necessarios do exercicio
        JK.turnOff(); // desliga o robo no final
        
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