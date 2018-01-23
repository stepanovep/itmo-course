package project.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.engine.executor.DeferredResultExecutor;
import project.engine.executor.NamedExecutors;
import project.engine.executor.NamedThreadPoolExecutor;
import project.engine.executor.ProjectCommandExecutor;
import project.properties.ApplicationProperties;

/**
 * @author Egor Stepanov
 * @since 19-01-2018.
 */
@Configuration
public class ApplicationConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    NamedThreadPoolExecutor transferThreadPoolExecutor() {
        return NamedExecutors.createExecutor("transferPool", applicationProperties.getTransferExecutorThreadPoolSize());
    }

    @Bean
    NamedThreadPoolExecutor accountThreadPoolExecutor() {
        return NamedExecutors.createExecutor("accountPool", applicationProperties.getAccountExecutorThreadPoolSize());
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
