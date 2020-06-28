/*

Nome: E1

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                Data: 04/03/2018

*/

// Lista de dependencias
//
import jkarel.World;
import jkarel.Robot;

//Exemplo de programa para uso com a classe JKarel.

public class E1 extends Robot {
    
    /**
    construtor padrao da classe E1.
    * 
    @param avenue - uma das coordenadas da posicao inicial
    @param street - outra das coordenadas da posicao inicial
    @param direction - direcao inicial
    @param beepers - quantidade inicial de marcadores
   
    */
    
    public E1(int avenue, int street, int direction, int beepers)
    {
        // metodo para repassar dados
        // ao construtor padrao da classe original (Robot)
        super(avenue, street, direction, beepers);
    } // end E1( )
    
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
        World.placeBeepers(5, 3, 6); // marcador no topo da escada
        
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
        
        if (steps > 0)
        {
            move();
            moveN(steps - 1);
        }
        
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
        doPartialTask(4, true); //5, 1 || direction = north
        
        doPartialTask(2, true); //5, 3 || direction = west
        pickBeeper();
        pickBeeper();
        pickBeeper();
        pickBeeper();
        pickBeeper();
        pickBeeper();
        
        doPartialTask(3, true); //2, 3 || direction = south
        putBeeper();
        turnLeft(); //2, 3 || direction = east
        
        doPartialTask(4, true); //6, 3 || direction = north
        putBeeper();
        putBeeper();
        
        doPartialTask(4, true); //6, 7 || direction = west
        
        doPartialTask(2, true); //4, 7 || direction = south
        putBeeper();
        putBeeper();
        putBeeper();
        
        doPartialTask(6, false); //4, 1 || direction = west
        
        doPartialTask(3, true);
        turnLeft();
        
    } // end doTask( )
    
    public static void main(String[] args)
    {
        // criar o ambiente com escada
        // OBS.: executar pelo menos uma vez,
        // antes de qualquer outra coisa
        // (depois de criado, podera' ser comentado)
        createWorld("E1.txt");
        
        // comandos para tornar o mundo visivel
        World.reset(); // limpar configuracoes
        World.setSpeed(7); // escolher velocidade
        World.readWorld("E1.txt"); // ler configuracao do ambiente
        
        // definir o objeto particular para executar as acoes (agente)
        E1 JK = new E1(1, 1, World.EAST, 0);
        
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
