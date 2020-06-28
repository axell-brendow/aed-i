import jkarel.Robot;
import jkarel.World;

class Turing extends Robot
{
    public final static int ZERO = World.WHITE;
    public final static int ONE  = World.BLACK;
    public final static int NONE = World.RED  ;

    public final static int LEFT = World.WEST ;
    public final static int RIGHT= World.EAST ;
    public final static int UP   = World.NORTH;
    public final static int DOWN = World.SOUTH;
    public final static int STOP = -1;
    public final static int NOP  =  0;

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
          return (  0 );
        }
        else
        if ( testBeeperColor ( ONE  ) )
        {
          return (  1 );
        }
        else
        {
          return ( -1 );
        }
      }
      else
      {
          return ( -1 );
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

public class TestTuring_02 extends Turing
{
  public TestTuring_02 ( int x, int y, int dir, int beepers )
  {
      super ( x, y, dir, beepers );
  } // end constructor

  public TestTuring_02 ( int x, int y, int dir, int beepers, int color )
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
         if ( nextToABeeper( ) )
         {
           rule ( 1 );
         }
         else
         {
           moveRight( );
           rule ( 1 );
         }
        break;
      case 1:
         if ( nextToABeeper( ) )
         {
           switch ( peek( )  )
           {
             case 0:
               action ( ZERO, RIGHT,  1   );
              break;
             case 1:
               action ( ONE , RIGHT,  1   );
              break;
             default:
               action ( NONE,  NOP , STOP );
           }
         }
         else
         {
           // action ( NONE,  NOP , STOP );
           action ( NONE, LEFT, 2 );
         }
        break;
      case 2:
         if ( nextToABeeper( ) )
         {
           switch ( peek( )  )
           {
             case 0:
              action  ( ONE , LEFT ,  2   );
              break;
             case 1:
              action  ( ZERO, LEFT ,  2   );
              break;
             default:
               action ( NONE,  NOP , STOP );
           }
         }
         else
         {
           final_State( );
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
      World.setSpeed ( 5 );

   // define robots
      TestTuring_02 jk = new TestTuring_02 ( 1, 6, World.NORTH, 8, ZERO );

   // actions

   // System.out.println ( "[TestTuring_02]: Report" );
      jk.rule( 0 );

   // System.out.println ( "[TestTuring_02]: Save e read the world" );
      World.saveWorld ("now.txt");
      World.reset( );
      World.readWorld ("now.txt");

  } // end main ( )
} // end TestTuring_02 class
