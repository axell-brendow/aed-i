/*

PUC Minas - Ciencia da Computacao     Nome: Guia0055

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

public class task2 extends Guia0055
{
    public task2(int avenue, int street, int direction, int beepers)
    {
        super(avenue, street, direction, beepers);
    }
    
    /**
     * Leva o robo ate o ponto de entrega
     * @param robot robo a ser gerenciado
     */
    
    public void goToDeliveryPoint(E1 robot)
    {
        robot.halfPathRight(5, 6);
    }
}
