package com.ramq.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException ex) {
        // Rediriger vers la page d'erreur personnalisée ou afficher un message d'erreur
        return "error"; // Ou renvoyer le nom de la vue correspondant à la page d'erreur personnalisée
    }
}
