package pl.es8it.mas.core.infrastructure.error;

public enum MasTechnicalError implements MasError {
    INTERNAL_SERVER_ERROR("MASERR-0001T", "Internal Server Error"),
    NOT_FOUND("MASERR-0002T", "Server Not Found");

    private final String errorCode;
    private final String errorMessage;

    MasTechnicalError(String errorCode, String errorMessage) {
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
