package pl.es8it.mas.core.infrastructure.web.rest.error.handler;

import pl.es8it.mas.core.infrastructure.error.MasError;
import pl.es8it.mas.core.infrastructure.web.rest.error.MasException;

public class ErrorResponseDTO {
    private final String errorCode;
    private final String errorMessage;

    public ErrorResponseDTO(MasError error) {
        this.errorCode = error.getErrorCode();
        this.errorMessage = error.getErrorMessage();
    }

    public ErrorResponseDTO(MasException exception) {
        this.errorCode = exception.getErrorCode();
        this.errorMessage = exception.getErrorMessage();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
