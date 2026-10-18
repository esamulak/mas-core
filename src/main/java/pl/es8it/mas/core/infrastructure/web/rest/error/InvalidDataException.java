package pl.es8it.mas.core.infrastructure.web.rest.error;

import pl.es8it.mas.core.infrastructure.error.MasBusinessError;

public class InvalidDataException extends MasException {

    public InvalidDataException() {
        super(MasBusinessError.INVALID_DATA);
    }
}
