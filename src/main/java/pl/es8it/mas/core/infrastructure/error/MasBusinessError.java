package pl.es8it.mas.core.infrastructure.error;

public enum MasBusinessError implements MasError {
    INVALID_DATA("MASERR-0001B", "Invalid data");

    private final String errorCode;
    private final String errorMessage;

    MasBusinessError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
