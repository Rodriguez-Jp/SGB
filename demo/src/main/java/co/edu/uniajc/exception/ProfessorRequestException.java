package co.edu.uniajc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProfessorRequestException extends RuntimeException {

    public ProfessorRequestException(String message) {
        super(message);
    }
    public ProfessorRequestException(String message, Throwable cause) {
    super(message, cause);
  }
}
