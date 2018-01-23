package project.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
@Getter
@Setter
@Component
@ConfigurationProperties("settings")
public class ApplicationProperties {

    private int currencyQueuePeriod;
    private int accountExecutorThreadPoolSize;
    private int transferExecutorThreadPoolSize;
}
