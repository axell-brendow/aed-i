// lista de dependencias

import IO.*;

/**
  *  Teste_IO04 - Graphics package
  *
  *  Copyright (c) 2016 by PUC-Minas / DCC
  *  All rights reserved.
  *
  * @author  PUC-Minas/DCC
  * @version 0.9i
  */

public class Teste_IO04
{
 //  main method
     public static void main ( String args [ ] )
     {
        IOGraphics io = new IOGraphics ( "2D Example"+" - "+IOGraphics.version( ),
                                          500, 500  );
     // local data
        int x;
        
        io.setBKColor ( "WHITE" );

        for ( x=1; x<=3; x=x+1 )
        {
          io.drawPoint   (  x,  0  , "BLACK", 0.003 );
          io.drawPoint   ( -x,  0  , "BLACK", 0.003 );
          io.drawPoint   (  0, +x  , "BLACK", 0.003 );
          io.drawPoint   (  0, -x  , "BLACK", 0.003 );
        } // end for

        io.drawLine      (  20,  20, 100, 100, "RED"   , 0.003 );
        io.drawRectangle ( 120, 120, 100, 100, "GREEN" , 0.003 );
        io.drawEllipse   ( 150, 120,  50, 100, "ORANGE", 0.003 );
        io.drawCircle    ( 150, 175,  30,      "PINK"  , 0.003 );
        io.drawArc       ( 150, 180,  50, 205, 335, "GRAY", 0.003 );


//        io.fillRectangle (  30,  30, 100, 100, "CYAN"     , 0.003 );

        io.fillEllipse   (-175, 150,  50,  50, "YELLOW"   , 0.003 );
        io.fillEllipse   (-180, 160,  10,  10, "DARK_GRAY", 0.003 );
        io.fillArc       (-170, 150,  50, -45, 45, "WHITE", 0.003 );
        io.fillCircle    (-125, 150,  15,      "MAGENTA"  , 0.003 );

        io.drawString    ( io.getCenterX(), io.getCenterY()+20, "CENTER", "BLUE" );
  } // end main ( )

} // end Teste_IO04
