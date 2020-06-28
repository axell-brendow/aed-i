/*

PUC Minas - Ciencia da Computacao     Nome: Guia0055

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

public class task3 extends Guia0055
{
    public task3(int avenue, int street, int direction, int beepers)
    {
        super(avenue, street, direction, beepers);
    }
    
    /**
     * Vai ate a posicao inicial do robo1 e deixa o marcador
     * @param robot robo a ser gerenciado
     */
    
    public void putBeeperOnRobot1Home(E1 robot)
    {
        robot.halfPathRight(2, 6);
        robot.putBeeper(); // o robo2 poe o marcador na posicao inicial do robo1
    }
}
