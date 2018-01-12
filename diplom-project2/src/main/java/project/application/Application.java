package project.application;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import project.entity.Account;
import project.repository.AccountRepository;

/**
 * @author Egor Stepanov
 * @since 11-01-2018.
 */
@SpringBootApplication
@EntityScan("project.entity")
@EnableJpaRepositories("project.repository")
public class Application implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private AccountRepository accountRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        accountRepository.save(new Account("egor", "egor@egor"));

        for (Account account : accountRepository.findAll()) {
            log.info("Crud find all(): account - {}", account.getName());
        }

        accountRepository.deleteAll();
    }
}

