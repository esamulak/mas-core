package pl.es8it.mas.core.infrastructure.web.rest.error;

import pl.es8it.mas.core.infrastructure.error.MasTechnicalError;

public class NotFoundException extends MasException {

    public NotFoundException() {
        super(MasTechnicalError.NOT_FOUND);
    }
}
