package pl.es8it.mas.core.infrastructure.web.rest.error;

import pl.es8it.mas.core.infrastructure.error.MasError;

public class MasException extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public MasException(MasError error) {
        this.errorCode = error.getErrorCode();
        this.errorMessage = error.getErrorMessage();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
