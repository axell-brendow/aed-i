/*

PUC Minas - Ciência da Computação     Nome: Guia0030

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  10.0                         Data: 11/03/2018

*/

import jkarel.Robot;
import jkarel.World;

import IO.*;

public class Guia0030 extends Robot
{

    /**
     * construtor padrao da classe Guia0030.
     *
     * @param avenue - uma das coordenadas da posicao inicial
     * @param street - outra das coordenadas da posicao inicial
     * @param direction - direcao inicial
     * @param beepers - quantidade inicial de marcadores
     */
    
    public Guia0030(int avenue, int street, int direction, int beepers)
    {
        
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
        
    } // end Guia0030( )

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
    * metodo para executar um comando.
    * @param option - comando a ser executado
    */
    
    public void execute( int option )
    {
        
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
        
    } // end execute( )
    
    /**
    * metodo para receber comandos de arquivo.
    * @param filename - nome do arquivo
    */
    
    public void translate( String filename )
    {
        // definir dados
        int option;
        FILE archive = new FILE ( FILE.INPUT, filename );
        String line;

        line = archive.readln ( ); // tentar ler a primeira linha
        
        // repetir enquanto houver dados
        while ( ! archive.eof( ) ) // testar se nao encontrado o fim
        {
            // decodificar a linha
            option = IO.getint( line );
            
            // tentar traduzir um comando
            IO.println ( dictionary ( option ) );
            
            // guardar mais um comando
            execute ( option );
            
            // tentar ler a proxima linha
            line = archive.readln( );
        } // end while
        
        // fechar o arquivo
        // RECOMENDAVEL para a leitura
        archive.close( );
    } // end read( )
    
    /**
    * metodo para traduzir um comando.
    * @param option - comando a ser traduzido
    */
    
    public String dictionary( int option )
    {
        // definir dado
        String word = ""; // palavra vazia
        
        // identificar comando
        switch ( option )
        {
            case 1: // virar para a esquerda

            word = "turnLeft( );";

            break;

            case 2: // virar para o sul

            word = "faceSouth( );";

            break;

            case 3: // virar para a direita

            word = "turnRight( );";

            break;

            case 4: // virar para o oeste

            word = "faceWest( );";

            break;

            case 5: // mover

            word = "move( );";

            break;

            case 6: // virar para o leste

            word = "faceEast( );";

            break;

            case 7: // pegar marcador

            word = "pickBeeper( );";

            break;

            case 8: // virar para o norte

            word = "faceNorth( );";

            break;

            case 9: // colocar marcador

            word = "putBeeper( );";

            break;
        } // end switch
        
        return word;
        
    } //end dictionary()
    
    /**
    * Acao principal: executar a tarefa descrita acima.
    */
    
    public static void main(String[] args)
    {
        // criar o ambiente com escada
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0030.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0030.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0030 JK = new Guia0030(1, 1, NORTH, 0);
        
        // ensinar sequencia de acoes
        // e grava-las em arquivo
        JK.translate("Tarefa0001.txt");
        
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