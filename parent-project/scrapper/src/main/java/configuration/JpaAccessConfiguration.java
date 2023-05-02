package configuration;

import dao.ChatDao;
import dao.LinkDao;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "app", name = "database-access-type", havingValue = "jpa")
public class JpaAccessConfiguration {
    @Bean
    LinkDao linksService(LinkDao linkController){
        return linkController;
    }
    @Bean
    ChatDao chatsService(ChatDao chatController){
        return chatController;
    }
}