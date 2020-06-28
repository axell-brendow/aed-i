import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: AxellIO

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 31/03/2018

*/

/*
Como a biblioteca IO não me possibilita diferenciar entradas nao numericas da
entrada 0 tanto nas funcoes de obtencao de tipos primitivos ( IO.readint() ) quanto
nas funcoes de obtencao de objetos (ex: IO.readInt()), criei essa aqui em que vou
conseguir fazer isso com os objetos.
*/

public class AxellIO
{
    public static final String LINE_SEPARATOR =
            System.getProperty("java.vendor.url").equals("http://www.android.com/")
            ? "\n" + (char) 65535 : System.lineSeparator();

    public static final String LAST_LINE_CHAR = LINE_SEPARATOR.substring(LINE_SEPARATOR.length() - 1);
    
    // ----------- FUNCOES DE UTILIDADE -----------
    
    /**
     * Percorre uma String contando a quantidade de um certo caractere nela
     * @param c caractere a se procurar
     * @param str String a percorrer
     * @return quantidade de vezes que o caractere aparece na String
     */
    
    public static int getCharTimes(char c, String str)
    {
        int times = 0;

        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == c)
            {
                times++;
            }
        }

        return times;
    }
    
    /**
     * Percorre um arranjo de caracteres checando a existencia de algum pre' determinado
     * @param c caractere a se procurar
     * @param array arranjo de caracteres a percorrer
     * @return true se o caractere existir no arranjo e false caso nao exista
     */
    
    public static boolean contains(char c, char[] array)
    {
        boolean contains = false;
        int counter = 0;

        while (!contains && counter < array.length)
        {
            contains = array[counter] == c;

            counter++;
        }

        return contains;
    }
    
    /**
     * Checa se um determinado caractere esta' num intervalo de caracteres
     * @param input caractere a ser analisado
     * @param lowerLimit limite inferior do intervalo
     * @param upperLimit limite superior do intervalo
     * @return true se o caractere estiver no intervalo e false se nao estiver
     */
    
    public static boolean isOnInterval(char input, char lowerLimit, char upperLimit)
    {
        return input >= lowerLimit && input <= upperLimit;
    }
    
    public static boolean isDigit(char input)
    {
        return isOnInterval(input, '0', '9');
    }
    
    public static boolean isLowerCase(char input)
    {
        return isOnInterval(input, 'a', 'z');
    }
    
    public static boolean isUpperCase(char input)
    {
        return isOnInterval(input, 'A', 'Z');
    }
    
    public static boolean isLetter(char input)
    {
        return isLowerCase(input) || isUpperCase(input);
    }
    
    public static boolean isFloat(char input)
    {
        return isDigit(input) || input == '.';
    }
    
    public static boolean isString(char input)
    {
        return !newLineOnInput(input) && input != ' ';
    }
    
    /**
     * Checa se um determinado caractere esta' num intervalo usual de caracteres
     * @param input caractere a ser analisado
     * @param accept caractere que simboliza o intervalo usual
     * (digitos, letras minusculas e maisculas, numeros reais...)
     * @return true se o caractere estiver no intervalo e false caso nao esteja
     */
    
    public static boolean isOnInterval(char input, char accept)
    {
        boolean bool = false;

        switch (accept)
        {
            case 'd':
                bool = isDigit(input);
                break;

            case 'u':
                bool = isUpperCase(input);
                break;

            case 'l':
                bool = isLowerCase(input);
                break;

            case 'a': // alphabet
                bool = isLetter(input);
                break;

            case 'f':
                bool = isFloat(input);
                break;
                    
            case 's':
                bool = isString(input);
                break;
        }

        return bool;
    }
    
    public static boolean isOnInterval(char input, char[] accept)
    {
        boolean bool = false;
        int index = 0;

        while (index < accept.length && bool == false)
        {
            switch (accept[index])
            {
                case 'd':
                    bool = isDigit(input);
                    break;

                case 'u':
                    bool = isUpperCase(input);
                    break;

                case 'l':
                    bool = isLowerCase(input);
                    break;

                case 'a': // alphabet
                    bool = isLetter(input);
                    break;

                case 'f':
                    bool = isFloat(input);
                    break;
                    
                case 's':
                    bool = isString(input);
                    break;
            }

            index++;
        }

        return bool;
    }
    
    /**
     * Limpa a entrada padrao (System.in)
     */
    
    public static void cleanSystemIn() throws IOException
    {
        while (!LAST_LINE_CHAR.equals((char) System.in.read() + ""));
    }
    
    /**
     * Limpa ou nao a entrada padrao de acordo com a ultima entrada
     * @param lastInput ultimo caractere lido
     */
    
    public static void cleanSystemIn(char lastInput) throws IOException
    {
        // so' limpa se a ultima leitura nao for o ultimo caractere que marca a quebra de linha
        if (!LAST_LINE_CHAR.equals(lastInput + ""))
        {
            cleanSystemIn();
        }
    }
    
    /**
     * Checa se existe algum caractere de quebra de linha num dado caractere
     * @param input caractere a ser analisado
     * @return true se o caractere for algum dos que marcam a quebra de linha
     */
    
    public static boolean newLineOnInput(char input)
    {
        return LINE_SEPARATOR.contains(input + "");
    }
    
    // ----------- FUNCOES DE ENTRADA DE DADOS -----------
    
    /**
     * Le uma String que tenha apenas alguns caracteres especificos
     * @param text texto a ser mostrado para o usuario antes da obtencao da String
     * @param accept caractere que simboliza o intervalo usual
     * (digitos, letras minusculas e maisculas, numeros reais...)
     * @return null se o usuario nao informar os caracteres desejados ou a String
     * com os caracteres especificos
     */
    
    public static String readSpecificString(String text, char accept) throws IOException
    {
        String specificString = null;
        char input;
        
        print(text);
        
        do
        {
            input = (char) System.in.read();
            
        } while (newLineOnInput(input) || input == ' ');

        if (isOnInterval(input, accept) || ((accept == 'd' || accept == 'f') && input == '-'))
        {
            specificString = "" + input;
            
            input = (char) System.in.read();
            
            while (isOnInterval(input, accept))
            {
                specificString += input;
                
                input = (char) System.in.read();
            }
            
            if (!newLineOnInput(input) && input != ' ' && input != ',')
            {
                specificString = null;
            }
        }
        
        cleanSystemIn(input);
        
        return specificString;
    }
    
    /**
     * Le uma String que tenha apenas alguns caracteres especificos
     * @param text texto a ser mostrado para o usuario antes da obtencao da String
     * @param accept caracteres que simbolizam os intervalos usuais
     * (digitos, letras minusculas e maisculas, numeros reais...)
     * @return null se o usuario nao informar os caracteres desejados ou a String
     * com os caracteres especificos
     */
    
    public static String readSpecificString(String text, char[] accept) throws IOException
    {
        String specificString = null;
        char input;
        
        print(text);

        do
        {
            input = (char) System.in.read();
            
        } while (newLineOnInput(input) || input == ' ');

        if (isOnInterval(input, accept) || ((contains('d', accept) || contains('f', accept)) && input == '-'))
        {
            specificString = "" + input;

            input = (char) System.in.read();

            while (isOnInterval(input, accept))
            {
                specificString += input;
                input = (char) System.in.read();
            }

            if (!newLineOnInput(input) && input != ' ' && input != ',')
            {
                specificString = null;
            }
        }
        
        cleanSystemIn(input);
        
        return specificString;
    }
    
    public static String readString(String text) throws IOException
    {
        return readSpecificString(text, 's');
    }
    
    public static int readint(String text) throws IOException
    {
        String data = readSpecificString(text, 'd');
        return data == null ? 0 : Integer.parseInt(data);
    }

    public static Integer readInt(String text) throws IOException
    {
        String data = readSpecificString(text, 'd');
        return data == null ? null : Integer.valueOf(data);
    }

    public static float readfloat(String text) throws IOException
    {
        String data = readSpecificString(text, 'f');
        return !isAValidDecimal(data) ? 0 : Float.parseFloat(data);
    }

    public static Float readFloat(String text) throws IOException
    {
        String data = readSpecificString(text, 'f');
        return !isAValidDecimal(data) ? null : Float.valueOf(data);
    }

    public static double readdouble(String text) throws IOException
    {
        String data = readSpecificString(text, 'f');
        return !isAValidDecimal(data) ? 0 : Double.parseDouble(data);
    }

    public static Double readDouble(String text) throws IOException
    {
        String data = readSpecificString(text, 'f');
        return !isAValidDecimal(data) ? null : Double.valueOf(data);
    }
    
    /**
     * Checa se determinada String representa um numero real possivel
     * de se converter pelas funcoes Double.parseDouble() e Float.parseFloat()
     * @param data String a ser analisada
     * @return true se for possivel converter e false caso nao
     */
    
    public static boolean isAValidDecimal(String data)
    {
        return data != null && data.charAt(0) != '.' && getCharTimes('.', data) <= 1;
    }
    
    // ----------- FUNCOES DE SAIDA DE DADOS -----------
    
    public static void print(String data)
    {
        System.out.print(data);
    }
    
    public static void println()
    {
        System.out.println();
    }
    
    public static void println(String data)
    {
        System.out.println(data);
    }
    
    public static void pause() throws IOException
    {
        cleanSystemIn((char) System.in.read());
    }
    
    public static void pause(String text) throws IOException
    {
        println(text);
        pause();
    }
}
