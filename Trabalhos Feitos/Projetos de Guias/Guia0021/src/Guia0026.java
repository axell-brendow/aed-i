/*

PUC Minas - Ciência da Computação     Nome: Guia0026

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  6.0                          Data: 11/03/2018

*/

import jkarel.Robot;
import jkarel.World;

import IO.*;

public class Guia0026 extends Robot
{

    /**
     * construtor padrao da classe Guia0026.
     *
     * @param avenue - uma das coordenadas da posicao inicial
     * @param street - outra das coordenadas da posicao inicial
     * @param direction - direcao inicial
     * @param beepers - quantidade inicial de marcadores
     */
    
    public Guia0026(int avenue, int street, int direction, int beepers)
    {
        
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
        
    } // end Guia0026( )

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
        
        // para colocar marcadores
        World.placeBeepers(4, 4, 3); // em (4,4), tres marcadores
        
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
        // definir dado local
        int contador = 0;
        
        // repetir (com teste no inicio)
        // enquanto houver marcador proximo
        while ( nextToABeeper( ) )
        {
            // coletar um marcador
            pickBeeper ( );
            
            // e contar mais um coletado
            contador = contador + 1;            
        } // end while
        
        // informar quantos foram coletados
        if ( contador > 0 )
        {
            // mostrar quantidade
            IO.println ( "Beepers = "+ contador );
            // pausa
            IO.pause ( "Apertar ENTER para continuar." );
        } // fim se
        
    } // end pickBeepers( )
    
    public void doRectangle( )
    {
        // definir dado local
        int vezes; // para contar
        
        // executar acoes repetidas vezes
        // repetir (com teste no inicio e variacao)
        for ( vezes=1; vezes<=4; vezes=vezes+1 )
        {
            // mover-se tres vezes ...
            moveN( 3 );
            
            // coletar marcadores, se houver
            pickBeepers( );
            
            // ... e virar 'a direira
            turnRight( );
        } // end for
        
    } // end doRectangle( )
    
    /**
    * metodo para mover o robot interativamente.
    */
    
    public void moveI( )
    {
        // definir dados
        int option;

        // apresentar comandos
        IO.println ( );
        IO.println ( "JKarel commands:" );
        IO.println ( );
        IO.println ( "0 - turnOff" );
        IO.println ( "1 - turnLeft 2 - to South" );
        IO.println ( "3 - turnRight 4 - to West" );
        IO.println ( "5 - move 6 - to East " );
        IO.println ( "7 - pickBeeper 8 - to North" );
        IO.println ( "9 - putBeeper" );
        IO.println ( );

        // repetir (com testes no fim)
        // enquanto opcao diferente de zero
        do
        {
            // ler opcao
            option = IO.readint ( "Command? " );

            // escolher acao dependente da opcao
            switch ( option )
            {
                case 0: // terminar
                // nao fazer nada
                break;

                case 1: // virar para a esquerda

                if ( leftIsClear ( ) )
                {
                    turnLeft( );
                } // end if

                break;

                case 2: // virar para o sul

                while ( ! facingSouth( ) )
                {
                    turnLeft( );
                } // end while

                break;

                case 3: // virar para a direita

                if ( rightIsClear ( ) )
                {
                    turnRight( );
                } // end if

                break;

                case 4: // virar para o oeste

                while ( ! facingWest( ) )
                {
                    turnLeft( );
                } // end while

                break;

                case 5: // mover

                if ( frontIsClear ( ) )
                {
                    move( );
                } // end if

                break;

                case 6: // virar para o leste

                while ( ! facingEast( ) )
                {
                    turnLeft( );
                } // end while

                break;

                case 7: // pegar marcador

                if ( nextToABeeper( ) )
                {
                    pickBeeper( );
                } // end if

                break;

                case 8: // virar para o norte

                while ( ! facingNorth( ) )
                {
                    turnLeft( );
                } // end while

                break;

                case 9: // colocar marcador

                if ( anyBeepersInBeeperBag( ) )
                {
                    putBeeper( );
                } // end if

                break;

                default:// nenhuma das alternativas anteriores
                // comando invalido
                IO.println ( "ERROR: Invalid command." );

                break;

            } // end switch
        }
        while ( option != 0 );
    
    } // end moveI( )
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        // criar o ambiente com escada
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0026.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0026.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0026 JK = new Guia0026(1, 1, NORTH, 0);
        
        // executar acoes repetidas vezes
        JK.moveI();
        
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

*/