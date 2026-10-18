package pl.es8it.mas.core.infrastructure.error;

public sealed interface MasError permits MasTechnicalError, MasBusinessError {

    String getErrorCode();

    String getErrorMessage();
}
