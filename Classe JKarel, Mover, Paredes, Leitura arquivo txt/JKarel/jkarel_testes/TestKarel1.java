import jkarel.Robot;
import jkarel.World;

public class TestKarel1 extends Robot
{
  public TestKarel1 ( int x, int y, int dir, int beepers )
  {
    super ( x, y, dir, beepers );
  } // end TestKarel

  public TestKarel1 ( int x, int y, int dir, int beepers, int color )
  {
    super ( x, y, dir, beepers, color );
  } // end TestKarel

  public void turnRight( )
  {
    turnLeft( );
    turnLeft( );
    turnLeft( );
  }

  public static void createWorld ( String filename )
  {
    World.reset ( );

    World.placeEWWall  ( 3, 2, 1 );
    World.placeNSWall  ( 3, 2, 1 , World.BLACK );
    World.placeBox     ( 5, 5, World.WHITE );
//  World.placeBox     ( 5, 5, 0 , Box.FIFO, World.WHITE );
    World.placeBeepers ( 4, 4, 3 , World.BLUE  );
    World.placeBeepers ( 6, 6, 4 );
    World.placeBeepers ( 2, 6, 2 , World.PINK  );

    World.placeBox     ( 1, 9, World.YELLOW);
    World.placeBox     ( 2, 9, World.BLUE  );
    World.placeBox     ( 3, 9, World.CYAN  );
    World.placeBox     ( 4, 9, World.GREEN );
    World.placeBox     ( 5, 9, World.PINK  );
    World.placeBox     ( 6, 9, World.RED   );
    World.placeBox     ( 7, 9, World.BLACK );

    World.saveWorld ( filename );
  } // end createWorld ( )

  public static void main ( String [] args )
  {
   // define items
      createWorld ( "test.txt" );

      World.setSpeed ( 5 );

   // define robots
      TestKarel1 jkW = new TestKarel1 ( 1, 4, 3, 0 );
      TestKarel1 jkS = new TestKarel1 ( 1, 3, 2, 0 );
      TestKarel1 jkE = new TestKarel1 ( 1, 2, 1, 0 );
      TestKarel1 jkN = new TestKarel1 ( 1, 1, 0, 3, World.RED );

   // actions
      System.out.println ( "TestKarel1 Report" );

      jkN.move( );
      jkN.move( );
      jkN.move( );
      jkN.turnLeft( );
      jkN.move( );
      jkN.move( );
      jkN.move( );

      System.out.println ( "Pick two blue beepers" );

      jkN.pickBeeper( );
      jkN.pickBeeper( );
      jkN.move( );

//    jkN.putBeeper ( );

      jkN.turnRight( );
      jkN.move( );

      if (jkN.nextToABox( ))
      {
        jkN.openBox( );
//      jkN.putBeeper( );
        System.out.println ( "Put two blue beepers into the box" );
        jkN.putBeeperInBox( );
        jkN.putBeeperInBox( );
//      jkN.closeBox( );
      } // end if

      jkN.move( );
//    jkN.pickBeeperFromBox( );
      jkN.turnLeft( );
      jkN.turnLeft( );
      jkN.move( );

      if (jkN.nextToABox( ))
      {
//      jkN.pickBeeperFromBox( );
        jkN.openBox( );
        System.out.println ( "Pick one blue beeper from box" );
        jkN.pickBeeperFromBox( );
        jkN.closeBox( );
      } // end if

      jkN.move( );
//    jkN.putBeeperInBox( );
      jkN.move( );
      System.out.println ( "Put one blue beeper in the world" );
      jkN.putBeeper( );

      jkN.turnLeft( );
      jkN.turnLeft( );
      jkN.move( );
      System.out.println ( "Put three red beepers in the world" );
      jkN.putBeeper( );
      jkN.putBeeper( );
      jkN.putBeeper( );

      jkN.turnLeft( );
      jkN.move( );

  } // end main ( )
} // end TestKarel class
