package Client;


import dtocl.GHResponse;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
//import ru.tinkoff.edu.java.scrapper.dto.webClient.GithubResponse;

public class GH {
    private static final String GITHUB_BASE_URL = "https://api.github.com";
    private WebClient webClient;
    private String URL;

    public GH(String customURL){
        URL = customURL;
        webClient = WebClient.builder()
                .baseUrl(URL)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public GH(){
        URL = GITHUB_BASE_URL;
        webClient = WebClient.builder()
                .baseUrl(GITHUB_BASE_URL)
                .defaultHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    public GHResponse fetchRepository(String user, String repo){
        return webClient
                .get()
                .uri("/repos/{user}/{repo}", user, repo)
                .retrieve()
                .bodyToMono(GHResponse.class)
                .block();
    }
}
