package br.com.fiap.onlineshop.OnlineShop.exception;

public class ConflictException extends RuntimeException {
    public ConflictException(String message) {
        super(message);
    }
}