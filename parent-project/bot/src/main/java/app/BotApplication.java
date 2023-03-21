package app;
import bot.configuration.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(RecordBot.class)
public class BotApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(RecordBot.class, args);
        RecordBot config = ctx.getBean(RecordBot.class);
        System.out.println(config);
    }
}

