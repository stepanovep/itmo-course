package project.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.engine.executor.DeferredResultExecutor;
import project.engine.executor.NamedExecutors;
import project.engine.executor.NamedThreadPoolExecutor;
import project.engine.executor.ProjectCommandExecutor;

/**
 * @author Egor Stepanov
 * @since 19-01-2018.
 */
@Configuration
public class ApplicationConfiguration {

    @Bean
    NamedThreadPoolExecutor transferThreadPoolExecutor() {
        return NamedExecutors.createExecutor("Transfer", 10);
    }

    @Bean
    NamedThreadPoolExecutor accountThreadPoolExecutor() {
        return NamedExecutors.createExecutor("Account", 5);
    }

    @Bean
    ProjectCommandExecutor transferCommandExecutor(NamedThreadPoolExecutor transferThreadPoolExecutor) {
        return new ProjectCommandExecutor(new DeferredResultExecutor(transferThreadPoolExecutor));
    }

    @Bean
    ProjectCommandExecutor accountCommandExecutor(NamedThreadPoolExecutor accountThreadPoolExecutor) {
        return new ProjectCommandExecutor(new DeferredResultExecutor(accountThreadPoolExecutor));
    }
}
