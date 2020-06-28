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

public class TestTuring_04 extends Turing
{
  public TestTuring_04 ( int x, int y, int dir, int beepers )
  {
      super ( x, y, dir, beepers );
  } // end constructor

  public TestTuring_04 ( int x, int y, int dir, int beepers, int color )
  {
      super ( x, y, dir, beepers, color );
  } // end constructor

  public static void createWorld ( String filename )
  {
    World.reset ( );

    World.placeBeepers  ( 2, 6, 1 , World.WHITE  ); // 0
    World.placeBeepers  ( 3, 6, 1 , World.BLACK  ); // 1
    World.placeBeepers  ( 4, 6, 1 , World.WHITE  ); // 0
    World.placeBeepers  ( 5, 6, 1 , World.WHITE  ); // 0
    World.placeBeepers  ( 6, 6, 1 , World.BLACK  ); // 1
    World.placeBeepers  ( 7, 6, 1 , World.BLACK  ); // 1
    World.placeBeepers  ( 8, 6, 1 , World.WHITE  ); // 0
    World.placeBeepers  ( 9, 6, 1 , World.BLACK  ); // 1

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

  public void action ( int symbol, int operation, int next_state )
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
    move ( operation  );
    rule ( next_state );
  }

  public void rule ( int state )
  {
    int symbol = peek( );

    if ( state == 0 )
    {
      if ( symbol == EMPTY )
      {
        action ( EMPTY, RIGHT, 1  );
      }
      else
      {
        putBeeper( ); // put back
        rule  ( 1, symbol );
      }
    }
    else
    {
      rule  ( state, symbol );
    }
  }

  public void rule ( int state, int symbol )
  {
    int [ ] [ ] rule = new int [4*4][5]; // instruction memory
    int operation;

    rule [0*4+0][0] = 0    ;  rule [0*4+1][0] = 0    ;  rule [0*4+2][0] = 0    ;  rule [0*4+3][0] = 0    ;
    rule [0*4+0][1] = ZERO ;  rule [0*4+1][1] = ONE  ;  rule [0*4+2][1] = NONE ;  rule [0*4+3][1] = EMPTY;
    rule [0*4+0][2] = ZERO ;  rule [0*4+1][2] = ONE  ;  rule [0*4+2][2] = NONE ;  rule [0*4+3][2] = EMPTY;
    rule [0*4+0][3] = RIGHT;  rule [0*4+1][3] = RIGHT;  rule [0*4+2][3] = RIGHT;  rule [0*4+3][3] = RIGHT;
    rule [0*4+0][4] = 1    ;  rule [0*4+1][4] = 1    ;  rule [0*4+2][4] = 1    ;  rule [0*4+3][4] = 1    ;

    rule [1*4+0][0] = 1    ;  rule [1*4+1][0] = 1    ;  rule [1*4+2][0] = 1    ;  rule [1*4+3][0] = 1    ;
    rule [1*4+0][1] = ZERO ;  rule [1*4+1][1] = ONE  ;  rule [1*4+2][1] = ONE  ;  rule [1*4+3][1] = EMPTY;
    rule [1*4+0][2] = ZERO ;  rule [1*4+1][2] = ONE  ;  rule [1*4+2][2] = NONE ;  rule [1*4+3][2] = EMPTY;
    rule [1*4+0][3] = RIGHT;  rule [1*4+1][3] = RIGHT;  rule [1*4+2][3] = NOP  ;  rule [1*4+3][3] = LEFT ;
    rule [1*4+0][4] = 1    ;  rule [1*4+1][4] = 1    ;  rule [1*4+2][4] = STOP ;  rule [1*4+3][4] = 2    ;

    rule [2*4+0][0] = 2    ;  rule [2*4+1][0] = 2    ;  rule [2*4+2][0] = 2    ;  rule [2*4+3][0] = 2    ;
    rule [2*4+0][1] = ZERO ;  rule [2*4+1][1] = ONE  ;  rule [2*4+2][1] = NONE ;  rule [2*4+3][1] = EMPTY;
    rule [2*4+0][2] = ONE  ;  rule [2*4+1][2] = ONE  ;  rule [2*4+2][2] = NONE ;  rule [2*4+3][2] = EMPTY;
    rule [2*4+0][3] = LEFT ;  rule [2*4+1][3] = LEFT ;  rule [2*4+2][3] = NOP  ;  rule [2*4+3][3] = LEFT ;
    rule [2*4+0][4] = 3    ;  rule [2*4+1][4] = 2    ;  rule [2*4+2][4] = STOP ;  rule [2*4+3][4] = 2    ;

    rule [3*4+0][0] = 3    ;  rule [3*4+1][0] = 3    ;  rule [3*4+2][0] = 3    ;  rule [3*4+3][0] = 3    ;
    rule [3*4+0][1] = ZERO ;  rule [3*4+1][1] = ONE  ;  rule [3*4+2][1] = NONE ;  rule [3*4+3][1] = EMPTY;
    rule [3*4+0][2] = ZERO ;  rule [3*4+1][2] = ONE  ;  rule [3*4+2][2] = EMPTY;  rule [3*4+3][2] = EMPTY;
    rule [3*4+0][3] = LEFT ;  rule [3*4+1][3] = LEFT ;  rule [3*4+2][3] = LEFT ;  rule [3*4+3][3] = LEFT ;
    rule [3*4+0][4] = 3    ;  rule [3*4+1][4] = 3    ;  rule [3*4+2][4] = STOP ;  rule [3*4+3][4] = STOP ;

 // decode
    if ( rule [state*4+0][1] == symbol )
    {
      symbol = rule [state*4+0][2]; operation = rule [state*4+0][3]; state = rule [state*4+0][4];
    }
    else
    if ( rule [state*4+1][1] == symbol )
    {
      symbol = rule [state*4+1][2]; operation = rule [state*4+1][3]; state = rule [state*4+1][4];
    }
    else
    if ( rule [state*4+2][1] == symbol )
    {
      symbol = rule [state*4+2][2]; operation = rule [state*4+2][3]; state = rule [state*4+2][4];
    }
    else
    if ( rule [state*4+3][1] == symbol )
    {
      symbol = rule [state*4+3][2]; operation = rule [state*4+3][3]; state = rule [state*4+3][4];
    }
    else
    {
      symbol = EMPTY;               operation = NOP;                 state = STOP;
    }

 // execute
    if ( state != STOP )
    {
      action ( symbol, operation, state );
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
      World.setSpeed (   5  );
      World.setBinary( true );

   // define robots
      TestTuring_04 jk = new TestTuring_04 ( 1, 6, World.NORTH, 0 );

   // actions

   // System.out.println ( "[TestTuring_04]: Report" );
      jk.rule ( 0 );

   // System.out.println ( "[TestTuring_04]: Save e read the world" );
      World.saveWorld ("now.txt");
      World.reset( );
      World.readWorld ("now.txt");

  } // end main ( )
} // end TestTuring_04 class
