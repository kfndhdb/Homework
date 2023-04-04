package configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tgBotClasses.TgBot;

@Configuration
public class TgBotConfig {
    @Bean("tg_bot_starter")
    public TgBot startBot(){
        TgBot tgBot = new TgBot();
        tgBot.startBot();
        return tgBot;
    }
}
