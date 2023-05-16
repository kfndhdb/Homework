package configuration;

import controllerBD.jdbcChat;
import controllerBD.jdbcLink;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(prefix = "app", name = "database-access-type", havingValue = "jdbc")
public class JdbcAccessConfiguration {
    @Bean
    jdbcLink linksService(jdbcLink linkController){
        return linkController;
    }
    @Bean
    jdbcChat chatsService(jdbcChat chatController){
        return chatController;
    }
}