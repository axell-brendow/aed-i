/*

PUC Minas - Ciencia da Computacao     Nome: ErrorClass

Autor: Axell Brendow Batista Moreira  Matricula: 631822

Versao:  1.0                          Data: 16/03/2018

*/

/**
 * Classe abstrata para tratamento de erros
 */

abstract class AErrorClass
{
    /**
     * Codigo de erro 0 representa a nao existencia de erro
     * @return true se a classe tiver um erro, caso contrario, false
     */
    
    public abstract boolean hasError();
    
    /**
     * @return codigo de erro da classe
     */
    
    public abstract int getErrorCode();
    
    /**
     * Metodo usado para mudar o codigo de erro da classe
     * @param newerrorCode novo codigo de erro
     */
    
    protected abstract void setErrorCode(int newErrorCode);
}

/**
 * Interface para tratamento de mensagens de erro
 */

interface ErrorInterface
{
    /**
     * @return Mensagem relativa ao codigo de erro da classe
     */
    
    String getErrorMessage();
}

/**
 * Classe para tratamento de erros
 */

public class ErrorClass extends AErrorClass implements ErrorInterface
{
    protected int errorCode; // armazenamento do codigo de erro da classe
    
    public ErrorClass()
    {
        errorCode = 0;
    }
    
    @Override
    public String toString()
    {
        return getErrorMessage();
    }
    
    @Override
    public int getErrorCode()
    {
        return errorCode;
    }
    
    @Override
    protected void setErrorCode(int newErrorCode)
    {
        errorCode = newErrorCode;
    }
    
    @Override
    public boolean hasError()
    {
        return errorCode == 0;
    }
    
    @Override
    public String getErrorMessage()
    {
        String message = "Sem mensagem de erro";
        
        switch (errorCode)
        {
            case 0:
                message = "Nao ha' erro";
                break;
        }
        
        return message;
    }
}
