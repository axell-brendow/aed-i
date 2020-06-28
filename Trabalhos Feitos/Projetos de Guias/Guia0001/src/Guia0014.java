/*

Guia0014

Autor:   Matricula: 631822   Nome: Axell Brendow Batista Moreira
Versao:  14.0                Data: 04/03/2018

*/

// Lista de dependencias
//
import jkarel.World;
import jkarel.Robot;

//Exemplo de programa para uso com a classe JKarel.

public class Guia0014 extends Robot {
    
    /**
    construtor padrao da classe Guia0014.
    * 
    @param avenue - uma das coordenadas da posicao inicial
    @param street - outra das coordenadas da posicao inicial
    @param direction - direcao inicial
    @param beepers - quantidade inicial de marcadores
   
    */
    
    public Guia0014(int avenue, int street, int direction, int beepers)
    {
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
    } // end Guia0014( )
    
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
        World.placeBeepers(2, 3, 1); // marcador no topo da escada
        World.placeBeepers(3, 7, 1); // marcador no topo da escada
        World.placeBeepers(6, 3, 1); // marcador no topo da escada
        
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
     * @param steps
     * @param turnLeft_ifNo_turnRight
     */
    
    public void doPartialTask(int steps, Boolean turnLeft_ifNo_turnRight)
    {
        
        // especificar acoes dessa parte da tarefa
        moveN(steps);
        
        if (turnLeft_ifNo_turnRight)
        {
            turnLeft();
        }
        else
        {
            turnRight();
        }
        
    } // end doPartialTask( )
    
    /**
     * metodo para especificar parte de uma tarefa.
     */
    
    public void doTask()
    {
        // especificar acoes da tarefa
        doPartialTask(5, true); //6, 1 || direction = north
        moveN(2); //6, 3 || direction = north
        pickBeeper();
        
        doPartialTask(4, true); //6, 7 || direction = west 
        moveN(3); //3, 7 || direction = west
        pickBeeper();
        
        doPartialTask(1, true); //2, 7 || direction = south
        
        doPartialTask(4, true); //2, 3 || direction = east
        pickBeeper();
        
        doPartialTask(3, false); //5, 3 || direction = south
        putBeeper();
        putBeeper();
        putBeeper();
        
        doPartialTask(2, false); //5, 1 || direction = west
        
        doPartialTask(4, true); //1, 1 || direction = south
        turnLeft(); //1, 1 || direction = east
        
    } // end doTask( )
    
    public static void main(String[] args)
    {
        // criar o ambiente com escada
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("Guia0014.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("Guia0014.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        Guia0014 JK = new Guia0014(1, 1, World.EAST, 0);
        
        // executar acoes
        JK.doTask();
        JK.turnOff();
        
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