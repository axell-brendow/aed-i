/*

Exemplo0050

Matricula: 631822            Nome: Axell Brendow Batista Moreira
Versao:  8.0                Data: 04/03/2018

*/

import IO.*;

public class Exemplo0053 {
    
    // ------ definicao de metodo auxiliar
    
    public static void metodo01()
    {
        // definir dados
        int x;
        
        // identificar o metodo
        IO.println( "Metodo 01" );
        
        // ler valor inteiro do teclado
        x = IO.readint( "Entrar com um valor inteiro: " );
        IO.println( "Valor lido = " + x );
        
    } // fim metodo01( )
    
    public static void metodo02 ( )
    {
        // definir dados
        int x;
        
        // definir dado para guardar o resultado
        int quantidade = 0;
        
        // identificar o metodo
        IO.println ( "Metodo 02" );
        
        // ler a quantidade do teclado
        quantidade = IO.readint ( "Entrar com a quantidade: " );
        
        while ( quantidade > 0 )
        {
            // ler valor inteiro do teclado
            x = IO.readint ( "Entrar com um valor inteiro: " );
            IO.println ( "Valor lido = " + x );
            
            // diminuir a quantidade
            quantidade = quantidade - 1;
        } // fim repetir
        
    } // fim metodo02( )
    
    public static void metodo03 ( )
    {
        // definir dados
        int x;
        
        // definir dado para guardar o resultado
        int quantidade = 0;
        
        // definir contador
        int contador;
        
        // identificar o metodo
        IO.println ( "Metodo 03" );
        
        // ler a quantidade do teclado
        quantidade = IO.readint ( "Entrar com a quantidade: " );
        contador = quantidade;
        
        while ( contador > 0 )
        {
            // ler valor inteiro do teclado
            x = IO.readint ( "Entrar com um valor inteiro: " );
            IO.println ( "Valor lido = " + x );
            // contar mais um valor lido
            contador = contador - 1;
        } // fim repetir
        
    } // fim metodo03( )
    
    public static void metodo04 ( )
    {
        // definir dados
        int x;
        
        // definir dado para guardar o resultado
        int quantidade = 0;
        
        // definir contador
        int contador;
        
        // identificar o metodo
        IO.println ( "Metodo 04" );
        
        // ler a quantidade do teclado
        quantidade = IO.readint ( "Entrar com a quantidade: " );
        contador = 1;
        
        while ( contador <= quantidade )
        {
            // ler valor inteiro do teclado
            x = IO.readint ( "Entrar com um valor inteiro: " );
            IO.println ( "Valor lido = " + x );
            // contar mais um valor lido
            contador = contador + 1;
        } // fim repetir
        
    } // fim metodo04( )
    
    public static void metodo05 ( )
    {
        // definir dados
        int x;
        
        // definir dado para guardar o resultado
        int quantidade = 0;
        
        // definir contador
        int contador;
        
        // identificar o metodo
        IO.println ( "Metodo 05" );
        
        // ler a quantidade do teclado
        quantidade = IO.readint ( "Entrar com a quantidade: " );
        contador = 0;
        
        while ( contador < quantidade )
        {
            // ler valor inteiro do teclado
            x = IO.readint ( "Entrar com um valor inteiro: " );
            IO.println ( "Valor lido = " + x );
            // contar mais um valor lido
            contador = contador + 1;
        } // fim repetir
        
    } // fim metodo05( )
    
    public static void metodo06()
    {
        
        int quantidade, contador = 1, valor;
        
        IO.println("Metodo 06");
        
        quantidade = IO.readint("Entrar com a quantidade: ");
        
        while (contador <= quantidade)
        {
            valor = IO.readint("Entrar com um valor inteiro: ");
            
            if (valor < 100)
            {
                IO.println("Valor menor que 100: " + valor);
                IO.println();
            }
            
            contador += 1;
        }
        
    }
    
    public static void metodo07()
    {
        
        int quantidade, contador = 1, valor;
        
        IO.println("Metodo 07");
        
        quantidade = IO.readint("Entrar com a quantidade: ");
        
        while (contador <= quantidade)
        {
            valor = IO.readint("Entrar com um valor inteiro: ");
            
            if (valor < 100 && valor % 2 == 0)
            {
                IO.println("Valor par e menor que 100: " + valor);
                /* Há uma aparente incoerência em ed03.pdf, pois,
                pede-se para separar os valores ímpares,
                mas pede para mostrar os pares, então
                não sei se mostro os pares ou os ímpares. */
                
                IO.println();
            }
            
            contador += 1;
        }
        
    }
    
    public static void metodo08()
    {
        
        int quantidade, contador = 1;
        double valor;
        
        IO.println("Metodo 08");
        
        quantidade = IO.readint("Entrar com a quantidade: ");
        
        while (contador <= quantidade)
        {
            valor = IO.readdouble("Entrar com um valor decimal: ");
            
            if (valor % 2 == 1 && valor >= 15 && valor <= 225)
            {
                IO.println("Valor ímpar no intervalo [15, 225]: " + valor);
                IO.println();
            }
            
            contador += 1;
        }
        
    }
    
    public static void main(String[] args)
    {
        // definir dado
        int opcao;
        
        do
        {
            // identificar
            IO.println ( "EXEMPLO0050 - Programa em Java" );
            IO.println ( "Autor: Axell Brendow Batista Moreira" );
            
            // mostrar opcoes
            IO.println();
            IO.println ( "Opcoes:" );
            IO.println ( "0 - Parar" );
            IO.println ( "1 - Metodo 01" );
            IO.println ( "2 - Metodo 02" );
            IO.println ( "3 - Metodo 03" );
            IO.println ( "4 - Metodo 04" );
            IO.println ( "5 - Metodo 05" );
            IO.println ( "6 - Metodo 06" );
            IO.println ( "7 - Metodo 07" );
            IO.println ( "8 - Metodo 08" );
            IO.println();
            
            // ler a opcao do teclado
            opcao = IO.readint ( "Qual a sua opcao? " );
            
            IO.println();
            
            // escolher qual metodo executar
            switch ( opcao )
            {
                case 0: // nao faz nada
                break;
                
                case 1: metodo01 ( );
                break;
                
                case 2: metodo02 ( );
                break;
                
                case 3: metodo03 ( );
                break;
                
                case 4: metodo04 ( );
                break;
                
                case 5: metodo05 ( );
                break;
                
                case 6: metodo06();
                break;
                
                case 7: metodo07();
                break;
                
                case 8: metodo08();
                break;
                
                default:
                IO.println ( "ERRO: Opcao invalida." );
                break;
            } // fim escolher
        }
        while ( opcao != 0 );
        
        // encerrar
        IO.pause ( "Apertar ENTER para terminar." );
        
    }
    
}
