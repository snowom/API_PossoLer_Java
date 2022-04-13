package br.com.possoler.api.api_posso_ler.exceptions;

public class ServerErrorException extends RuntimeException{

    public ServerErrorException(String message)
    {
        super(message);
    }
}
