/*

PUC Minas - Ciencia da Computacao     Nome: Guia0055

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

public class task1 extends Guia0055
{
    public task1(int avenue, int street, int direction, int beepers)
    {
        super(avenue, street, direction, beepers);
    }
    
    /**
     * Leva o robo ate o marcador e o pega
     * @param robot robo a ser gerenciado
     */
    
    public void goAndGetTheBeeper(E1 robot)
    {
        robot.halfPathRight(2, 5); // robo1 vai ate o marcador
        robot.pickBeeper();
    }
}
