package clientBeans;

import dtocl.DataClass;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class BotClient {
    private static final String BOT_BASE_URL = "http://localhost:8080/updates";

    private final WebClient webClient;

    public BotClient(String customeURL){
        webClient = WebClient.builder()
                .baseUrl(customeURL)
                .build();
    }

    public BotClient(){
        webClient = WebClient.builder()
                .baseUrl(BOT_BASE_URL)
                .build();
    }


    public void sendUpdate(DataClass linkUpdateRequest) {
        webClient
                .post()
                .uri("")
                .body(BodyInserters.fromValue(linkUpdateRequest))
                .exchangeToMono(clientResponse -> Mono.just(!clientResponse.statusCode().isError()))
                .block();
    }
}