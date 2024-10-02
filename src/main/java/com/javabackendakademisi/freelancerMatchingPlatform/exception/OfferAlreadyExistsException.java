package com.javabackendakademisi.freelancerMatchingPlatform.exception;

//Bir projeye birden fazla teklif yapılamaz.
public class OfferAlreadyExistsException extends RuntimeException{

    public OfferAlreadyExistsException(String message) {
        super(message);
    }
}
