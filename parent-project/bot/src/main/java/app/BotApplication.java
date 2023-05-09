package app;

import bot.configuration.RecordBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import Services.ScrapperQueueProducer;
import tgBotClasses.TgBot;


@SpringBootApplication
@EnableConfigurationProperties(RecordBot.class)
public class BotApplication {
    public static void main(String[] args) {
        var ctx = SpringApplication.run(BotApplication.class, args);
        RecordBot config = ctx.getBean(RecordBot.class);
        TgBot bot = new TgBot();
        bot.startBot();
        BotController.bot = bot.getTgBotMethods();
        ScrapperQueueProducer.botMethods = bot.getTgBotMethods();
        System.out.println(config);
    }
}

