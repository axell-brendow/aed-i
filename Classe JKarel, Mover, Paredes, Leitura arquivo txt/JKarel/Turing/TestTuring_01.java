import jkarel.Robot;
import jkarel.World;

class Turing extends Robot
{
    public final static int ZERO = World.WHITE;
    public final static int ONE  = World.BLACK;

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

    public boolean test_0 ( )
    {
      return ( hasBeepers( ) && testBeeperColor ( ZERO ) );
    }

    public boolean test_1 ( )
    {
      return ( hasBeepers( ) && testBeeperColor ( ONE  ) );
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

public class TestTuring_01 extends Turing
{
  public TestTuring_01 ( int x, int y, int dir, int beepers )
  {
      super ( x, y, dir, beepers );
  } // end constructor

  public TestTuring_01 ( int x, int y, int dir, int beepers, int color )
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

  public void state_0( )
  {
    faceEast( );
    moveRight( );
    state_1( );
  }

  public void state_1( )
  {
    if ( nextToABeeper( ) )
    {
      pickBeepers( );
      if ( test_0 ( ) )
      {
        put_0( );
        moveRight( );
        state_1( );
      }
      else
      if ( test_1 ( ) )
      {
        put_1( );
        moveRight( );
        state_1( );
      }
      else
      {
        final_State( );
      }
    }
    else
    {
      moveLeft( );
      state_2( );
    }
  }

  public void state_2( )
  {
    if ( nextToABeeper( ) )
    {
      pickBeepers( );
      if ( test_0 ( ) )
      {
        put_1( );
        moveLeft( );
        state_2( );
      }
      else
      if ( test_1 ( ) )
      {
        put_0( );
        moveLeft( );
        state_2( );
      }
      else
      {
        final_State( );
      }
    }
    else
    {
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
      TestTuring_01 jk = new TestTuring_01 ( 1, 6, World.NORTH, 8, ZERO );

   // actions

   // System.out.println ( "[TestTuring_01]: Report" );
      jk.state_0( );

   // System.out.println ( "[TestTuring_01]: Save e read the world" );
      World.saveWorld ("now.txt");
      World.reset( );
      World.readWorld ("now.txt");

  } // end main ( )
} // end TestTuring_01 class
