package com.example.aluracursos.foro.forohubpau.problemas;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroresModi {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity Er404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity Er400(MethodArgumentNotValidException e) {
        var error = e.getFieldErrors().stream()
                .map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(ValidacionDeIntegralidad.class)
    public ResponseEntity ErrValidacionException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity ErrValidacionException(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    private record DatosErrorValidacion(String campo, String message) {
        public DatosErrorValidacion(FieldError fieldError) {
            this(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }
}

