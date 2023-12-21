package com.gnosiseducacao.api.model;

public class IdadeInvalidaException extends RuntimeException{
    public IdadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}
