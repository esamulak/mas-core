package pl.es8it.mas.core.infrastructure.web.rest.error.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.es8it.mas.core.infrastructure.error.MasTechnicalError;
import pl.es8it.mas.core.infrastructure.web.rest.error.InternalServerErrorException;
import pl.es8it.mas.core.infrastructure.web.rest.error.InvalidDataException;
import pl.es8it.mas.core.infrastructure.web.rest.error.MasException;
import pl.es8it.mas.core.infrastructure.web.rest.error.ServiceNotFoundException;
import pl.es8it.mas.core.infrastructure.web.rest.error.ServiceTimeoutException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> handleUnexpectedError(Exception ex) {
        log.error("Unhandled exception", ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponseDTO(MasTechnicalError.INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler({MasException.class, InternalServerErrorException.class})
    public ResponseEntity<ErrorResponseDTO> handleInternalServerError(MasException ex) {
        log.error("{}: {}", ex.getErrorCode(), ex.getErrorMessage(), ex);
        return response(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    @ExceptionHandler(InvalidDataException.class)
    public ResponseEntity<ErrorResponseDTO> handleInvalidData(InvalidDataException ex) {
        log.warn("{}: {}", ex.getErrorCode(), ex.getErrorMessage());
        return response(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<ErrorResponseDTO> handleServiceNotFound(ServiceNotFoundException ex) {
        log.error("{}: {}", ex.getErrorCode(), ex.getErrorMessage(), ex);
        return response(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(ServiceTimeoutException.class)
    public ResponseEntity<ErrorResponseDTO> handleServiceTimeout(ServiceTimeoutException ex) {
        log.error("{}: {}", ex.getErrorCode(), ex.getErrorMessage(), ex);
        return response(HttpStatus.GATEWAY_TIMEOUT, ex);
    }

    private ResponseEntity<ErrorResponseDTO> response(HttpStatus status, MasException ex) {
        return ResponseEntity.status(status)
                .body(new ErrorResponseDTO(ex));
    }
}
