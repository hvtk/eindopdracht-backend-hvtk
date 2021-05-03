package henkvantkruijs.Springbootfinalassignmentbootcamphvtk.controller;

import henkvantkruijs.Springbootfinalassignmentbootcamphvtk.exception.RecordNotFoundException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> execption(RecordNotFoundException exception) {
        return (ResponseEntity<Object>) ResponseEntity.notFound().build();
    }

}
