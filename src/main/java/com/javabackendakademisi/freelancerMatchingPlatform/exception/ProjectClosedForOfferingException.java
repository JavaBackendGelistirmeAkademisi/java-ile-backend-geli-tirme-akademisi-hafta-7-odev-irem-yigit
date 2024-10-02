package com.javabackendakademisi.freelancerMatchingPlatform.exception;

// Proje teklif vermeye kapalı olabilir
public class ProjectClosedForOfferingException extends RuntimeException{

    public ProjectClosedForOfferingException(String message){
        super(message);

    }
}
