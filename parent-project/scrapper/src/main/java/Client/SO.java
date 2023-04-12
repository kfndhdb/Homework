package Client;

import dtocl.SOResponse;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


public class SO {
    private static final String STACK_OVERFLOW_BASE_URL = "https://api.stackexchange.com";
    private WebClient webClient;
    private String URL;

    public SO(String customURL){
        URL = customURL;
        webClient = WebClient.builder()
                .baseUrl(URL)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public SO(){
        URL = STACK_OVERFLOW_BASE_URL;
        webClient = WebClient.builder()
                .baseUrl(URL)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    SOResponse fetchQuestion(long id){
        return webClient
                .get()
                .uri("/questions/{id}", id)
                .retrieve()
                .bodyToMono(SOResponse.class)
                .block();
    }
}
