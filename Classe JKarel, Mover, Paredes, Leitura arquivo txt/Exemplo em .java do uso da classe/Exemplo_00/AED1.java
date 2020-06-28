// Comentarios de uma unica linha servem para incluir informacoes

import jkarel.Robot; // importar a classe Robot do pacote jkarel
import jkarel.World; // importar a classe World do pacote jkarel

import IO.*;         // importar todas as classes do pacote IO

/*
   Comentarios em varias linhas servem para dar maiores detalhes.
   Para compilar: javac AED1.java
   Para executar: java  AED1
*/

/**
   Comentarios para documentacao automatica (JavaDoc) precedem
   as descricoes de classes, de seus atributos (dados) e comportamentos (acoes).
   OBS.: Uma (e unica) classe publica e executavel devera' estar em arquivo com o mesmo nome.
*/
public class AED1
{// <- um bloco contido por chaves serve para definir dados e/ou acoes

 /** uma funcao e' um metodo para se obter valor de certo tipo (String) */
    public static String mudarLinha ( )          // <- parenteses servem para indicar acoes
    {                                            //    que podem conter parametros, ou nao
     // obter o codigo dependente do sistema operacional
        return ( "\n" );                         // <- o retorno e' obrigatorio em funcoes
    } // fim da funcao ( )

 /** um procedimento (void) e' um metodo para definir outros dados e/ou acoes particulares
    (incluindo usos de outros metodos), para usos futuros. */
    public static void identificar ( )
    {
     // exibir mensagem na saida padrao(console)
        System.out.println ( "AED1 v0.1" );
     // exibir mensagens sem mudar de linha
        System.out.print   ( "PUC-Minas" );
        System.out.print   ( " - " );
        System.out.print   ( "ICEI" );
     // mudar de linha
        System.out.print   ( mudarLinha( ) );      // <- uso da funcao
    } // fim do metodo ( )

 /** para ser executavel devera' haver uma acao principal (main) como ponto de partida. */
    public static void main ( String [ ] args )   // <- parametros obrigatorios, neste caso
    {
     // usar metodo estatico definido nesta classe
        identificar ( );                          // <- uso de procedimento
     // saltar linha (forma alternativa)
        System.out.println ( );
     // exibir mensagens e constantes
        System.out.print ( "-> Valores imutaveis (constantes)\n" );
        System.out.print
        (
          "boolean: " + true + "\t" +   /* tabulacao  (TAB) */
          "char   : " + 'a'  + "\n" +   /* mudanca de linha */
          "double : " + 3.14 + "\t" +
          "integer: " + 10   + "\n"
        );

     // tipos primitivos e armazenadores de dados (variaveis)

     // byte    - inteiro de  8 bits com sinal em complemento de dois
     // (-128 <= byte <= 127)
        byte aByte = 100;

     // short   - inteiro de 16 bits com sinal em complemento de dois
     // (-32,768 <= short <= 32767)
        short aShort = 10000;

     // int     - inteiro de 32 bits com sinal em complemento de dois
     // (-2147483648 <= int <= 2147483647)
        int aInt = 1;

     // long    - inteiro de 64 bits com sinal em complemento de dois
     // (-9223372036854775808 <= long <= 9223372036854775807)
        long aLong = 100000L;             // usar a letra 'L' e' obrigadorio

     // float   - real de precisao simples,
     //           em ponto flutuante 32-bits no padrão IEEE 754
        float aFloat = 234.5f;            // usar a letra 'f' e' obrigatorio

     // double  - real de precisao dupla,
     //           em ponto flutuante 64-bits no padrão IEEE 754
        double aDouble       =  123.4,    //                      -2
               anotherDouble = -1.234e-2; // o mesmo que -1.234x10

     // boolean - valores logicos (false, true)
        boolean aBoolean       = false;
        boolean anotherBoolean = true;

     // char    - caractere Unicode (simbolo) de 16 bits
        char aChar = 'A';                 // usar apostrofos e' obrigatorio

     // usar final para tornar uma definicao imutavel.
        final double pi = 3.141592;       // similar a Math.PI, mas menos preciso

        System.out.println ( );
        System.out.println ( "-> Valores mutaveis (variaveis)" );
        System.out.println ( "byte   : " + aByte    );
        System.out.println ( "short  : " + aShort   );
        System.out.println ( "int    : " + aInt     );
        System.out.println ( "float  : " + aFloat   );
        System.out.println ( "double : " + aDouble  );
        System.out.println ( "boolean: " + aBoolean );

     // objetos podem ter atributos e metodos (procedimentos e/ou funcoes)

     // String  - armazenador para simbolos
        String aNullString   = null; // dado inexistente, nao tem tamanho
        String anEmptyString = "";   // dad0 vazio      , tamanho = 0
        String aString       = "Exemplo de String";

        String twoLineString = "Exemplo \n com mudanca de linha"; // '\n' = mudar de linha
        String tabbedString  = "Exemplo \t com tabulacao";        // '\t' = tabular

        System.out.println ( );
        System.out.println ( "-> Cadeias de caracteres" );
        System.out.println ( aNullString   );
        System.out.println ( "\"" + anEmptyString + "\""
                             + "\n tem tamanho = " + anEmptyString.length( ) );
        System.out.println ( aString
                             + "\n tem tamanho = " + aString.length( )
                             + "\n o primeiro caractere e' " + aString.charAt(0)
                             + "\n o ultimo   caractere e' " + aString.charAt(aString.length()-1)
                           );
        System.out.println ( twoLineString );
        System.out.println ( tabbedString  );

     // Arranjos = grupos de dados homogeneos
     //            cujo tamanho precisara' ser determinado
        boolean [ ] booleanArray = null;           // grupo ainda inexistente
        char    [ ] charArray    = new char   [1]; // grupo para  1 item
        double  [ ] doubleArray  = new double [1]; // grupo para  2 item
        int     [ ] intArray     = new int   [10]; // grupo para 10 itens
        String  [ ] stringArray  = new String [2]; // grupo para  2 itens

     // forma alternativa para definir e dar valores ao arranjo
        boolean [ ] boolArray    = { false, true };

        System.out.println ( "\n-> Arranjos" );

     // acesso ao primeiro elemento em arranjo
        System.out.println ( "boolArray na posicao [0]: " + boolArray[0] );

     // acesso ao primeiro elemento em arranjo
        intArray [0] = 1;
        System.out.println ( "intArray na posicao  [0]: " + intArray [0] ); // => 1
     // acesso ao ultimo   elemento em arranjo
        System.out.println ( "intArray na posicao  [9]: " + intArray [9] ); // => 0

     // Operadores
        System.out.println ( "\n-> Operadores" );

        int x1 = 1, x2 = 2; // definir dados com valores iniciais

     // expressoes aritmeticas basicas (e saida formatada)
        System.out.printf ( "1+2  = %d%n"   , (x1 + x2) ); // => 3
        System.out.printf ( "2-1  = %d%n"   , (x2 - x1) ); // => 1
        System.out.printf ( "2*1  = %d%n"   , (x2 * x1) ); // => 2
        System.out.printf ( "1/2  = %d%n"   , (x1 / x2) ); // => 0 (truncado para baixo)
        System.out.printf ( "1/2  = %5.2f\n", ((double) x1 / x2) ); // => 0.5

     // resto inteiro da divisao (modulo)
        System.out.printf ( "10%%2 = %d%n" , (10 % 2) );   // => 0 (  par)
        System.out.printf ( "11%%2 = %d%n" , (11 % 2) );   // => 1 (impar)

     // comparacoes (expressoes relacionais)
        System.out.println ( "3 == 2 ? " + (3 == 2) );     // => false
        System.out.println ( "3 != 2 ? " + (3 != 2) );     // => true
        System.out.println ( "3 >  2 ? " + (3 >  2) );     // => true
        System.out.println ( "3 <  2 ? " + (3 <  2) );     // => false
        System.out.println ( "2 <= 2 ? " + (2 <= 2) );     // => true
        System.out.println ( "2 >= 2 ? " + (2 >= 2) );     // => true

     // Estruturas de Controle
        System.out.println ( "\n-> Estruturas de Controle" );

     // alternativas (testes)
        int y = 10;
        System.out.print   ( "\n->Teste" );
        if ( y == 10 )
        {
            System.out.println ( " se verdadeiro, sera' exibido" );
        }
        else if (y > 10)
        {
            System.out.println ( " maior, nao sera' exibido" );
        }
        else
        {
            System.out.println ( " menor, tambem nao sera' exibido" );
        } // fim do bloco da alternativa

     // alternativa multipla
     //    com tipos de dados primitivos: byte, short, char e int
     // ou com objetos: Character, Byte, Short e Integer
     // ou com tipos enumerados (Enum)
     // ou com String e algumas classes especiais (casos particulares)
        int month = 3;
        String monthString;
        switch ( month )
        {
            case 1:
                    monthString = "Janeiro";
                    break; // indispensavel
            case 2:
                    monthString = "Fevereiro";
                    break; // indispensavel
            case 3:
                    monthString = "Marco";
                    break; // indispensavel
            default:       // nenhuma das opcoes anteriores
                    monthString = "Algum outro mes";
                    break; //   dispensavel
        } // fim do bloco da alternativa
        System.out.println ( "apos a alternativa multipla  : " + monthString);

     // atribuicao condicional (alternativa em forma abreviada)
        int    aValue = 9;
        String aStringValue = (aValue >= 10) ? "X" : (""+(char)(aValue+48));
        System.out.println ( "apos a atribuicao condicional: "+aValue+" = "+aStringValue );

        System.out.println ( "\n->Repeticao" );

     // repeticao (loop) com teste no fim
        int controlDoWhile = 0;                    // iniciar
        do
        {
           System.out.print ( " "+controlDoWhile );// mostrar
           controlDoWhile = controlDoWhile+1;      // passar 'a proximo
        }
        while ( controlDoWhile < 5 );              // testar
        System.out.println ( " e apos a repeticao: " + controlDoWhile);

     // repeticao (loop) com teste no inicio
        int controlWhile = 0;                      // iniciar
        while ( controlWhile < 5 )                 // testar
        {
           System.out.print ( " "+controlWhile );  // mostrar
           controlWhile = controlWhile+1;          // passar 'a proximo
        } // fim do bloco da repeticao
        System.out.println ( " e apos a repeticao: " + controlWhile );

     // repeticao (loop) com teste no inicio e variacao
        int controlFor;
        for ( controlFor=0; controlFor<5; controlFor=controlFor+1 )
        { //  iniciar       testar        passar ao proximo
           System.out.print ( " " + controlFor );
        } // fim do bloco da repeticao
        System.out.println ( " e apos a repeticao: " + controlFor );

     // repeticao (loop) para todos os valores em grupos ou listas
        int [ ] intList = { 1,2,3,4,5 };
        for( int controlList : intList )
        {
           System.out.print ( " " + controlList );
        } // fim do bloco da repeticao
        System.out.println ( " e apos a repeticao: (nao ha' valor disponivel)" );

     // conversoes entre tipos de dados ( com tratamento de excecoes )
        try
        {
          aValue       = Integer.parseInt ( "123" ); // int    <- String
          aStringValue = Integer.toString (  123  ); // String <- int
        }
        catch ( Exception ex )
        {
          // para tratar erro eventual nas conversoes
        } // fim do bloco para tratar excecao

     // Classes com atributos e metodos
        System.out.println ( "\n-> Classes e Métodos" );

     // usar metodos estaticos definidos em outra classe (IO)
        IO.println ( "IO version " + IO.version( ) );
        IO.pause   ( "Apertar ENTER para continuar." );

     // criar instancia (objeto) de uma classe e usar metodos nela definidos
        Robot JK = new Robot ( 1, 1, World.EAST, 1 ); // uso de construtor (new) para criar
        JK.move ( );         // <- objeto (JK) usara' o metodo move() da classe (Robot)
        JK.putBeeper ( );
        JK.move ( );
        JK.turnLeft  ( );
        JK.move ( );
        JK.turnLeft  ( );
        JK.move ( );
        JK.turnLeft  ( );
        JK.move ( );
        JK.pickBeeper( );
        JK.turnLeft  ( );
        JK.turnLeft  ( );
        JK.turnLeft  ( );
        JK.move ( );
        JK.turnLeft  ( );
        JK.turnLeft  ( );
        JK.turnOff( );
    } // fim do metodo main ( )

} // fim da classe AED1
