/*

Guia0010

Autor:   Matricula: 631822   Nome: Axell Brendow Batista Moreira
Versao:  10.0                Data: 04/03/2018

 */

// Lista de dependencias
//
import jkarel.World;
import jkarel.Robot;

//Exemplo de programa para uso com a classe JKarel.

public class Guia0010 extends Robot {
    
    /**
    construtor padrao da classe Guia0010.
    * 
    @param avenue - uma das coordenadas da posicao inicial
    @param street - outra das coordenadas da posicao inicial
    @param direction - direcao inicial
    @param beepers - quantidade inicial de marcadores
   
    */
    
    public Guia0010(int avenue, int street, int direction, int beepers)
    {
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
    } // end Guia0010( )
    
    /**
    metodo para criar configuracoes do ambiente.
     *
    @param nome do arquivo onde guardar a configuracao
     */
    
    public static void createWorld(String nome)
    {
        // o executor deste metodo (World - agente)
        // ja' foi definido na classe original (Robot)
        World.reset(); // limpar configuracoes
        
        // para nao exibir os passos de criacao do ambiente
        World.setTrace(false); // (opcional)
        
        // para colocar marcador(es)
        World.placeBeepers(4, 4, 1); // marcador no topo da escada
        
        // para guardar em arquivo
        World.saveWorld(nome); // gravar configuracao
    } // end createWorld( )

    /**
    metodo para virar a direita.
     */
    
    public void turnRight()
    {
        // o executor deste metodo
        // deve virar tres vezes 'a esquerda
        turnLeft();
        turnLeft();
        turnLeft();
    } // end turnRight( )
    
    /**
     * metodo para mover varios passos.
     *
     * @param steps - passos a serem dados.
     */
    
    public void moveN(int steps)
    {
        // definir dado local
        int step; // contador de passos
        
        // repetir para contador
        // comecando em 1,
        // enquanto menor ou igual 'a quantidade,
        // variando de 1 em 1
        for ( step = 1; step <= steps; step = step + 1 )
        {
            // dar um passo
            move( );
        } // end for
        
    } // end moveN( )
    
    /**
     * metodo para especificar parte de uma tarefa.
     */
    
    public void doPartialTask()
    {
        // especificar acoes dessa parte da tarefa
        moveN(3);
        turnLeft();
    } // end doPartialTask( )

    /**
     * metodo para especificar parte de uma tarefa.
     */
    
    public void doTask()
    {
        // especificar acoes da tarefa
        doPartialTask();
        doPartialTask();
        
        // testar se ha' marcador antes ...
        if ( nextToABeeper( ) )
        {
            // ... de tentar carrega-lo
            pickBeeper( );
            doPartialTask( );
            // ... e tentar descarregar
            putBeeper( );
        }
        else
        {
            doPartialTask( );
        } // end if
        
        doPartialTask();
        turnLeft();
    } // end doTask( )
    
    public static void main(String[] args)
    {
        // criar o ambiente com escada
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0010.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0010.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0010 JK = new Guia0010(1, 1, World.EAST, 0);
        
        // executar acoes
        JK.doTask();
        
    } // end main( )
    
} // end class

/*
---------- testes

Versao  Teste
1.0     01. ( OK )   teste inicial
2.0     01. ( OK )   teste da tarefa
3.0     01. ( OK )   teste da tarefa parcial
4.0     01. ( OK )   teste do apanhar marcador
5.0     01. ( OK )   teste do colocar marcador
6.0     01. ( OK )   teste da repeticao do movimento
7.0     01. ( OK )   teste com marcador na posicao (4,4)
        02. ( OK )   teste sem marcador na posicao (4,4)
8.0     01. ( OK )   teste com a quantidade de marcadores
9.0     01. ( OK )   teste com outra forma de repeticao
10.0     01. ( OK )   teste com outra forma de alternativa
*/