package pl.es8it.mas.core.infrastructure.web.rest.error;

import pl.es8it.mas.core.infrastructure.error.MasTechnicalError;

public class InternalServerErrorException extends MasException {

    public InternalServerErrorException() {
        super(MasTechnicalError.INTERNAL_SERVER_ERROR);
    }
}
