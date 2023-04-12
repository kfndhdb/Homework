package Client;


import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

public class ClientConfiguration {

    @Bean("githubClient")
    public GH githubClient(WebClient githubWebClient) {
        return new GH();
    }

    @Bean("stackOverflowClient")
    public SO stackOverflowClient() {
        return new SO();
    }

}