import IO.*;

import jkarel.Robot;
import jkarel.World;

class Turing extends Robot
{
    public final static int ZERO  = World.WHITE;
    public final static int ONE   = World.BLACK;
    public final static int NONE  = World.RED  ;

    public final static int LEFT  = World.WEST ;
    public final static int RIGHT = World.EAST ;
    public final static int UP    = World.NORTH;
    public final static int DOWN  = World.SOUTH;

    public final static int STOP  = -2;
    public final static int EMPTY = -1;
    public final static int NOP   =  0;

    public Turing ( int x, int y, int dir, int beepers )
    {
      super ( x, y, dir, beepers );
    } // end constructor

    public Turing ( int x, int y, int dir, int beepers, int color )
    {
      super ( x, y, dir, beepers, color );
    } // end constructor

    public void pickBeepers ( )
    {
        if ( nextToABeeper( ) )
    	{
          pickBeeper( );
          pickBeepers( );
        }
    }

    public boolean peek_0 ( )
    {
      return ( hasBeepers( ) && testBeeperColor ( ZERO ) );
    }

    public boolean peek_1 ( )
    {
      return ( hasBeepers( ) && testBeeperColor ( ONE  ) );
    }

    public int peek ( )
    {
      if ( nextToABeeper( ) )
      {
        pickBeepers ( );
        if ( testBeeperColor ( ZERO  ) )
        {
          return (  ZERO );
        }
        else
        if ( testBeeperColor ( ONE  ) )
        {
          return (  ONE  );
        }
        else
        {
          return ( NONE  );
        }
      }
      else
      {
          return ( EMPTY );
      }
    }

    public void put_0 ( )
    {
    	pickBeepers ( );
    	if ( hasBeepers( ) )
    	{
          paintBeeper ( ZERO );
          putBeeper ( );
        }
    }

    public void put_1 ( )
    {
    	pickBeepers ( );
    	if ( hasBeepers( ) )
    	{
          paintBeeper ( ONE );
          putBeeper ( );
        }
    }

    public void turnRight( )
    {
      turnLeft( );
      turnLeft( );
      turnLeft( );
    } // end turnRight ( )

    public void faceNorth ( )
    {
        if ( ! facingNorth( ) )
    	{
          turnLeft( );
          faceNorth( );
        }
    }

    public void faceEast ( )
    {
        if ( ! facingEast( ) )
    	{
          turnLeft( );
          faceEast( );
        }
    }

    public void faceSouth ( )
    {
        if ( ! facingSouth( ) )
    	{
          turnLeft( );
          faceSouth( );
        }
    }

    public void faceWest ( )
    {
        if ( ! facingWest( ) )
    	{
          turnLeft( );
          faceWest( );
        }
    }

    public void moveLeft ( )
    {
    	faceWest( );
    	if ( frontIsClear( ) )
    	{
           move( );
    	}
    	else
    	{
           final_State( );
    	}
    }

    public void moveRight ( )
    {
    	faceEast( );
    	if ( frontIsClear( ) )
    	{
           move( );
    	}
    	else
    	{
           final_State( );
    	}
    }

    public void moveUp ( )
    {
    	faceNorth( );
    	if ( frontIsClear( ) )
    	{
           move( );
    	}
    	else
    	{
           final_State( );
    	}
    }

    public void moveDown ( )
    {
    	faceSouth( );
    	if ( frontIsClear( ) )
    	{
           move( );
    	}
    	else
    	{
           final_State( );
    	}
    }

    public void final_State( )
    {
      turnOff( );
    }

}

public class TestTuring_03 extends Turing
{
  public TestTuring_03 ( int x, int y, int dir, int beepers )
  {
      super ( x, y, dir, beepers );
  } // end constructor

  public TestTuring_03 ( int x, int y, int dir, int beepers, int color )
  {
      super ( x, y, dir, beepers, color );
  } // end constructor

  public static void createWorld ( String filename )
  {
    World.reset ( );

    World.placeBeepers  ( 2, 6, 1 , World.WHITE  );
    World.placeBeepers  ( 3, 6, 1 , World.BLACK  );
    World.placeBeepers  ( 4, 6, 1 , World.WHITE  );
    World.placeBeepers  ( 5, 6, 1 , World.WHITE  );
    World.placeBeepers  ( 6, 6, 1 , World.BLACK  );
    World.placeBeepers  ( 7, 6, 1 , World.BLACK  );
    World.placeBeepers  ( 8, 6, 1 , World.WHITE  );
    World.placeBeepers  ( 9, 6, 1 , World.BLACK  );

    World.saveWorld ( filename );
  } // end createWorld ( )

  public void move ( int direction )
  {
    switch ( direction )
    {
      case LEFT:
        moveLeft( );
       break;
      case RIGHT:
        moveRight( );
       break;
      case UP:
        moveUp( );
       break;
      case DOWN:
        moveDown( );
       break;
      default:
        // no operation (NOP)
    }
  }

  public void action ( int symbol, int direction, int next_state )
  {
    switch ( symbol )
    {
      case  ZERO:
        put_0( );
       break;
      case  ONE :
        put_1( );
       break;
      default:
        // no operation (NOP)
    }
    move ( direction  );
    rule ( next_state );
  }

  public void rule ( int state )
  {
    switch ( state )
    {
      case 0:
         switch ( peek( )  )
         {
           case EMPTY:
             action ( EMPTY, RIGHT, 1  );
            break;
           default   :
             putBeeper( ); // put back
             rule   ( 1 );
         }
        break;
      case 1:
         switch ( peek( )  )
         {
           case ZERO:
             action ( ZERO , RIGHT,  1   );
            break;
           case ONE :
             action ( ONE  , RIGHT,  1   );
            break;
           case NONE:
             action ( NONE , NOP  , STOP );
            break;
           default:
             action ( EMPTY, LEFT ,  2   );
         }
        break;
      case 2:
         switch ( peek( )  )
         {
           case ZERO:
            action  (  ONE , LEFT ,  3   );
            break;
           case ONE :
            action  (  ONE , LEFT ,  2   );
            break;
           default:
            action  (  ONE , NOP  , STOP );
         }
        break;
      case 3:
         switch ( peek( )  )
         {
           case ZERO:
            action  ( ZERO , LEFT ,  3   );
            break;
           case ONE :
            action  ( ONE  , LEFT ,  3   );
            break;
           default:
            action  ( EMPTY, LEFT , STOP );
         }
        break;
      default:
        final_State( );
    }
  }

  public static void main ( String [] args )
  {
   // define items
      createWorld ( "test.txt" );

   // set speed
      World.setSpeed (   5  );
      World.setBinary( true );

   // define robots
      TestTuring_03 jk = new TestTuring_03 ( 1, 6, World.NORTH, 0 );

   // actions

   // System.out.println ( "[TestTuring_03]: Report" );
      jk.rule( 0 );

   // System.out.println ( "[TestTuring_03]: Save e read the world" );
      World.saveWorld ("now.txt");
      World.reset( );
      World.readWorld ("now.txt");

  } // end main ( )
} // end TestTuring_03 class
