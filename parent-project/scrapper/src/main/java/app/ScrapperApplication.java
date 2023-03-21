package app;

import .*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(ApplicationConfig )
public class ScrapperApplication {
    public static void main (String[] args) {
        var ctx = SpringApplication.run(ScrapperApplication , args);
        ApplicationConfig config = ctx.getBean(ApplicationConfig );
        System.out.println(config);
    }
}
