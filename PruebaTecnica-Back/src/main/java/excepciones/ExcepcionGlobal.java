package excepciones;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Oskar
 */
@RestControllerAdvice
public class ExcepcionGlobal extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(LongitudMaxima.class)
    public ResponseEntity<ErrorObject> LongitudMaximaExcepcion(LongitudMaxima ex) {
        ErrorObject errorObject = new ErrorObject();
        
        errorObject.setMensaje(ex.getMessage());
        
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(LongitudCelular.class)
    public ResponseEntity<ErrorObject> LongitudCelularExcepcion(LongitudCelular ex) {
        ErrorObject errorObject = new ErrorObject();
        
        errorObject.setMensaje(ex.getMessage());
        
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }
}
