package pl.es8it.mas.core.infrastructure.web.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import pl.es8it.mas.core.infrastructure.web.rest.error.NotFoundException;

@Configuration
public class RestClientConfiguration {

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder
                .defaultStatusHandler(
                        status -> status.value() == 404,
                        (request, response) -> {
                            throw new NotFoundException();
                        }
                )
                .build();
    }
}
