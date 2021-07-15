package br.com.mercadolivre.seuimovel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DistrictNotFoundHandler {
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException (DistrictNotFoundException e){
        return new ResponseEntity<>("Bairro não cadastrado! Tente cadastrar pela rota /district/create", HttpStatus.BAD_REQUEST);

    }
}
