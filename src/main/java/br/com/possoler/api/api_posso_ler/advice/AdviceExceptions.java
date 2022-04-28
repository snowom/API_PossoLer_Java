package br.com.possoler.api.api_posso_ler.advice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import exceptions.ClientErrorException;
import exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import exceptions.ServerErrorException;
import org.springframework.web.client.HttpClientErrorException;

@RestControllerAdvice
public class AdviceExceptions {
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServerErrorException.class)
    private Map<String, String> serverErrorException(ServerErrorException e)
    {
        Map<String, String> response = new HashMap<>();
        response.put("error", e.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ClientErrorException.class)
    private Map<String, String> clientErrorException(ClientErrorException e)
    {
        Map<String, String> response = new HashMap<>();
        response.put("error", e.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    private Map<String, String> httpMessageNotReadableException(HttpMessageNotReadableException e){
        Map<String, String> response = new HashMap<>();
        response.put("error", e.getMessage());
        response.put("message", "Json invalido");
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    private Map<String, String> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        Map<String, String> response = new HashMap<>();
        response.put("error", e.getMessage());
        response.put("message", "Falha ao executar query!");
        return response;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(MethodArgumentNotValidException.class)
	private Map<String, String> argumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error) -> {
			String errorMessage = ((FieldError) error).getDefaultMessage();
			errors.put("error_message", errorMessage);
		});
		return errors;
	}

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    @ExceptionHandler(MissingServletRequestParameterException.class)
    private Map<String, String> missingServletRequestParameterException(MissingServletRequestParameterException e){
        Map<String, String> response = new HashMap<>();
        response.put("error", e.getMessage());
        return response;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    private Map<String, String> httpClientErrorExceptionUnauthorized(HttpClientErrorException.Unauthorized e){
        Map<String, String> response = new HashMap<>();
        response.put("response", "Token inválido ou expirado!");
        return response;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingRequestHeaderException.class)
    private Map<String, String> missingRequestHeaderException(MissingRequestHeaderException e){
        Map<String, String> response = new HashMap<>();
        response.put("response", "Falha ao obter headers");
        response.put("error_message", e.getMessage());
        return response;
    }


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(NotFoundException.class)
    private Map<String, String> notFoundException(NotFoundException e){
        Map<String, String> response = new HashMap<>();
        response.put("response", e.getMessage());
        return response;
    }
}
