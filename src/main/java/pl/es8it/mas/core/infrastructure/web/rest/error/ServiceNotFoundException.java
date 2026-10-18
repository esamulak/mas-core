package pl.es8it.mas.core.infrastructure.web.rest.error;

import pl.es8it.mas.core.infrastructure.error.MasTechnicalError;

public class ServiceNotFoundException extends MasException {

    public ServiceNotFoundException() {
        super(MasTechnicalError.SERVICE_NOT_FOUND);
    }
}
