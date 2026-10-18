package pl.es8it.mas.core.infrastructure.web.rest.error;

import pl.es8it.mas.core.infrastructure.error.MasTechnicalError;

public class ServiceTimeoutException extends MasException {

    public ServiceTimeoutException() {
        super(MasTechnicalError.SERVICE_TIMEOUT);
    }
}
