package scrapper.configuration;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.validation.annotation.Validated;

import java.time.Duration;

@Validated
@ConfigurationProperties(prefix = "app", ignoreUnknownFields = false)
public record RecordScrapper(@NotNull String test) {
    @Value("${app.scheduler.interval}")
    private static Duration schedulerInterval;

}
