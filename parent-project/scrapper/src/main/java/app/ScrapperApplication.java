package app;

import scrapper.configuration.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RecordScrapper.class)
public class ScrapperApplication {
    public static void main (String[] args) {
        var ctx = SpringApplication.run(ScrapperApplication.class , args);
        RecordScrapper config = ctx.getBean(RecordScrapper.class );
        System.out.println(config);
    }
}
