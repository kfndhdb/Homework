package clientBeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class ClientConfiguration {

    @Bean("githubClient")
    public GHC githubClient(WebClient githubWebClient) {
        return new GHC();
    }

    @Bean("stackOverflowClient")
    public SOClient stackOverflowClient() {
        return new SOClient();
    }

}