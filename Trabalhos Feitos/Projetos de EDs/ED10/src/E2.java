import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: E2

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 09/04/2018

*/

public class E2
{
    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) throws IOException, CloneNotSupportedException
    {
        //Identificacao do autor
        AxellIO.println("PUC Minas - Ciencia da Computacao     Nome: E2");
        AxellIO.println("Autor: Axell Brendow                  Versao:  1.0\n");
        
        ArrayClass arr1 = new ArrayClass(5);
        ArrayClass arr2 = arr1.clone();
        
        AxellIO.println("arr1 == arr2 = " + arr1.equals(arr2));
        
        AxellIO.pause("\nPressione ENTER para terminar");
    }
    
}