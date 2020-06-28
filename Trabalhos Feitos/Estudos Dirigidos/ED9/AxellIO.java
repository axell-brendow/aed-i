import java.io.IOException;

/*

PUC Minas - Ciência da Computação     Nome: AxellIO

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 31/03/2018

*/

/*
Como a IO não me possibilita diferenciar entradas nao numericas da
entrada 0, criei essa aqui em que vou conseguir fazer isso.
*/

public class AxellIO
{
    public static final String LINE_SEPARATOR = System.lineSeparator();

    public static final String LAST_LINE_CHAR =
            System.getProperty("java.vendor.url").equals("http://www.android.com/")
            ? "" + (char) 65535 : LINE_SEPARATOR.substring(LINE_SEPARATOR.length() - 1);
    
    // ----------- FUNCOES DE UTILIDADE -----------
    
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
            }

            index++;
        }

        return bool;
    }
    
    public static void cleanSystemIn() throws IOException
    {
        while (!LAST_LINE_CHAR.equals((char) System.in.read() + ""));
    }
    
    public static void cleanSystemIn(char lastInput) throws IOException
    {
        if (!LAST_LINE_CHAR.equals(lastInput + ""))
        {
            cleanSystemIn();
        }
    }
    
    public static boolean newLineOnInput(char input)
    {
        return LINE_SEPARATOR.contains(input + "");
    }
    
    // ----------- FUNCOES DE ENTRADA DE DADOS -----------
    
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
        String string = null;
        char input;
        
        print(text);

        do
        {
            input = (char) System.in.read();
            
        } while (newLineOnInput(input) || input == ' ');

        while (!newLineOnInput(input) && input != ' ' && input != ',')
        {
            string += input;
            input = (char) System.in.read();
        }
        
        cleanSystemIn(input);
        
        return string;
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
        return (data == null || data.charAt(0) == '.' || getCharTimes('.', data) > 1) ? 0 : Float.parseFloat(data);
    }

    public static Float readFloat(String text) throws IOException
    {
        String data = readSpecificString(text, 'f');
        return (data == null || data.charAt(0) == '.' || getCharTimes('.', data) > 1) ? null : Float.valueOf(data);
    }

    public static double readdouble(String text) throws IOException
    {
        String data = readSpecificString(text, 'f');
        return (data == null || data.charAt(0) == '.' || getCharTimes('.', data) > 1) ? 0 : Double.parseDouble(data);
    }

    public static Double readDouble(String text) throws IOException
    {
        String data = readSpecificString(text, 'f');
        return (data == null || data.charAt(0) == '.' || getCharTimes('.', data) > 1) ? null : Double.valueOf(data);
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
