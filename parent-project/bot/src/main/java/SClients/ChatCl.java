package SClients;

import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class ChatCl {
    private static final String CHAT_BASE_URL = "https://localhost:8080/tg-chat";
    private WebClient webClient;
    private String URL;
    public ChatCl(){
        URL = CHAT_BASE_URL;
        webClient = WebClient.builder()
                .baseUrl(CHAT_BASE_URL)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
    public ChatCl(String customUrl){
        URL = customUrl;
        webClient = WebClient.builder()
                .baseUrl(URL)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
    public void addChat(long id){
        webClient
                .post()
                .uri("/{id}", id);
    }
    public void deleteChat(long id){
        webClient
                .delete()
                .uri("/{id}", id);
    }
}
