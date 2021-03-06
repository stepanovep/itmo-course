package project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import project.entity.CurrencyRate;
import project.properties.ApplicationProperties;
import project.repository.CurrencyRateRepository;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Сервис для {@link CurrencyRate}
 *
 * @author Egor Stepanov
 * @since  14-01-2018.
 */
@Service
public final class CurrencyRateService {

    private static final Logger log = LoggerFactory.getLogger(CurrencyRateService.class);

    private final CurrencyRateRepository currencyRateRepository;
    private final ApplicationProperties applicationProperties;

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    private static final Random rnd = new Random();

    public CurrencyRateService(CurrencyRateRepository currencyRateRepository,
                               ApplicationProperties applicationProperties) {
        this.currencyRateRepository = currencyRateRepository;
        this.applicationProperties = applicationProperties;
    }

    public void startUpdatingQueue() {
        scheduler.scheduleAtFixedRate(() -> {
            Double dollar = 60 + rnd.nextDouble();
            Double euro = 70 + rnd.nextDouble();
            currencyRateRepository.save(new CurrencyRate(dollar, euro));
            log.info("currency rates updated: dollar={}, euro={}", dollar, euro);
        }, 0, applicationProperties.getCurrencyQueuePeriod(), TimeUnit.MINUTES);
    }
}
