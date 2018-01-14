package project.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import project.entity.Account;
import project.repository.AccountRepository;
import project.repository.CurrencyRateRepository;
import project.service.CurrencyRateService;

/**
 * @author Egor Stepanov
 * @since 11-01-2018.
 */
@SpringBootApplication
@EntityScan("project.entity")
@EnableJpaRepositories("project.repository")
@ComponentScan(basePackages = {"project.executor", "project.service" })
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CurrencyRateService currencyRateService;

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        accountRepository.save(new Account("egor", "egor@egor"));

        for (Account account : accountRepository.findAll()) {
            log.info("Crud find all(): account - {}", account.getName());
        }

        currencyRateService.startUpdatingQueue();
    }
}


