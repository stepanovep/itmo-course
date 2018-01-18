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
@ConfigurationProperties("test")
public class ApplicationProperties {

    private String var1;
    private int var2;
}
