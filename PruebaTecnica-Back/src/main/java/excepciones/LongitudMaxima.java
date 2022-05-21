package excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Oskar
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LongitudMaxima extends RuntimeException {
    public LongitudMaxima(String mensaje){
        super(mensaje);
    }
}
