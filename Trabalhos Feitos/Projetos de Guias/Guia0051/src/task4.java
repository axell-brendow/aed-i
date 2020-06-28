/*

PUC Minas - Ciencia da Computacao     Nome: Guia0055

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

public class task4 extends Guia0055
{
    public task4(int avenue, int street, int direction, int beepers)
    {
        super(avenue, street, direction, beepers);
    }
    
    /**
     * leva o robo ate sua posicao inicial e gira-o para a direcao
     * em que estava olhando no inicio
     * @param avenue avenida em que ele deve parar
     * @param street rua em que ele deve parar
     * @param directionToTurnOnEnd direcao para virar no final do processo
     * @param robot robo a ser gerenciado
     */
    
    public void goHome(int avenue, int street, int directionToTurnOnEnd, E1 robot)
    {
        robot.halfPathLeft(avenue, street);
        robot.moveAndTurn(0, directionToTurnOnEnd);
    }
}
