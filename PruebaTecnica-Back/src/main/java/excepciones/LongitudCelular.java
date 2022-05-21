package excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Oskar
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LongitudCelular extends RuntimeException {
    public LongitudCelular(String mensaje){
        super(mensaje);
    }
}
