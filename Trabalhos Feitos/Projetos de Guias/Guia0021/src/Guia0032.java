/*

PUC Minas - Ciência da Computação     Nome: Guia0032

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  12.0                         Data: 12/03/2018

*/

import jkarel.Robot;
import jkarel.World;

import IO.*;

public class Guia0032 extends Robot
{

    /**
     * construtor padrao da classe Guia0032.
     *
     * @param avenue - uma das coordenadas da posicao inicial
     * @param street - outra das coordenadas da posicao inicial
     * @param direction - direcao inicial
     * @param beepers - quantidade inicial de marcadores
     */
    
    public Guia0032(int avenue, int street, int direction, int beepers)
    {
        
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
        
    } // end Guia0032( )

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
        
        World.placeNSWall(2, 2, 3);
        World.placeNSWall(2, 6, 3);
        
        World.placeNSWall(4, 2, 2);
        World.placeNSWall(4, 5, 1);
        World.placeNSWall(4, 7, 2);
        
        World.placeNSWall(5, 2, 2);
        World.placeNSWall(5, 5, 1);
        World.placeNSWall(5, 7, 2);
        
        World.placeNSWall(7, 2, 3);
        World.placeNSWall(7, 6, 3);
        
        // criar paredes horizontais
        
        World.placeEWWall(3, 1, 2);
        World.placeEWWall(6, 1, 2);
        
        World.placeEWWall(5, 3, 1);
        
        World.placeEWWall(3, 4, 2);
        World.placeEWWall(6, 4, 2);
        
        World.placeEWWall(3, 5, 2);
        World.placeEWWall(6, 5, 2);
        
        World.placeEWWall(5, 6, 1);
        
        World.placeEWWall(3, 8, 2);
        World.placeEWWall(6, 8, 2);
        
        // para colocar marcadores
        World.placeBeepers(5, 3, 1);
        World.placeBeepers(5, 7, 1);
        
        World.placeBeepers(4, 5, 1);
        World.placeBeepers(6, 5, 1);
        
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
    
    public void goPickAndBack()
    {
        moveN(2);
        pickBeepers();
        turnLeft();
        turnLeft();
        moveN(2);
        turnLeft();
    }
    
    public void horizontalWalk()
    {
        moveN(3);
        turnLeft();
    }
    
    public void verticalWalk()
    {
        moveN(4);
        turnLeft();
    }
    
    /**
    *  metodo para mover o robo
    */
    
    public void doTask()
    {
        
        move();
        horizontalWalk();
        goPickAndBack();
        
        horizontalWalk();
        
        verticalWalk();
        goPickAndBack();
        
        verticalWalk();
        
        horizontalWalk();
        goPickAndBack();
        
        horizontalWalk();
        
        verticalWalk();
        goPickAndBack();
        
        verticalWalk();
        
        while(!facingWest()) turnLeft(); // vira para oeste
        
        move();
        
        putBeepers(4);
        
        while(!facingEast()) turnLeft(); // vira para leste
        
    }
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        //Identificacao do autor
        IO.println("PUC Minas - Ciencia da Computacao     Nome: Guia0032");
        IO.println("Autor: Axell Brendow                  Versao:  12.0\n");
        
        // criar o ambiente com escada
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0032.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0032.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0032 JK = new Guia0032(1, 1, EAST, 0);
        
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