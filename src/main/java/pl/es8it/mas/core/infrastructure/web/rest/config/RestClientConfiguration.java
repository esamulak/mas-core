package pl.es8it.mas.core.infrastructure.web.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.RestClient;
import pl.es8it.mas.core.infrastructure.web.rest.error.InternalServerErrorException;
import pl.es8it.mas.core.infrastructure.web.rest.error.InvalidDataException;
import pl.es8it.mas.core.infrastructure.web.rest.error.MasException;
import pl.es8it.mas.core.infrastructure.web.rest.error.ServiceNotFoundException;
import pl.es8it.mas.core.infrastructure.web.rest.error.ServiceTimeoutException;

import java.net.ConnectException;
import java.net.NoRouteToHostException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.http.HttpTimeoutException;

@Configuration
public class RestClientConfiguration {

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
                .requestInterceptor((request, body, execution) -> {
                    try {
                        return execution.execute(request, body);
                    } catch (SocketTimeoutException | HttpTimeoutException ex) {
                        throw new ServiceTimeoutException();
                    } catch (ConnectException | UnknownHostException | NoRouteToHostException ex) {
                        throw new ServiceNotFoundException();
                    }
                })
                .defaultStatusHandler(HttpStatusCode::isError, (request, response) -> {
                    throw toMasException(response.getStatusCode());
                })
                .build();
    }

    private static MasException toMasException(HttpStatusCode status) {
        return switch (status.value()) {
            case 400 -> new InvalidDataException();
            case 404, 503 -> new ServiceNotFoundException();
            case 408, 504 -> new ServiceTimeoutException();
            default -> new InternalServerErrorException();
        };
    }
}
