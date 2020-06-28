import jkarel.Robot;
import jkarel.World;

class Robot1 extends Robot
{
 // construtor
    public Robot1 ( int avenue, int street, int direction, int beepers, String name )
    {
       super( avenue, street, direction, beepers, name );
    } // end constructor

 // main parallel action
    public void act ( )
    {
       while ( true )
       {
         move ( );
         move ( );
         move ( );
         move ( );
         move ( );
         turnLeft ( );
         turnLeft ( );
       } // end while
    } // end act ( )
} // end class

class Robot2 extends Robot
{
 // construtor
    public Robot2 ( int avenue, int street, int direction, int beepers, String name )
    {
        super( avenue, street, direction, beepers, name );
    } // end constructor

   public void act ( )
   {
     while ( true )
     {
        move ( );
        move ( );
        turnLeft ( );
     } // end while
    } // end act ( )
} // end class

public class TestKarel3
{
   public static void main ( String [ ] args )
   {
    // definir dados
       Robot1 robot1a = new Robot1 ( 3,2,World.NORTH,3, "robot1a" );
       Robot1 robot1b = new Robot1 ( 4,2,World.EAST ,4, "robot1b" );
       Robot2 robot2a = new Robot2 ( 7,7,World.NORTH,2, "robot2a" );

    // informar dados sobre robos
       System.out.println ( "Test parallel robots" );
       System.out.println ( );
       System.out.println ( "Robots:" );
       System.out.println ( ""+robot1a.getName( )+" ("+robot1a.beepers( )+")" );
       System.out.println ( ""+robot1b.getName( )+" ("+robot1b.beepers( )+")" );
       System.out.println ( ""+robot2a.getName( )+" ("+robot2a.beepers( )+")" );
       System.out.println ( );

    // iniciar execucao em paralelo
       robot1a.start ( );
       robot1b.start ( );
       robot2a.start ( );

    } // end main ( )
} // end class
