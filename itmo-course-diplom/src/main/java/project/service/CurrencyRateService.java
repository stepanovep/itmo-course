package project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.entity.CurrencyRate;
import project.repository.CurrencyRateRepository;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Egor Stepanov
 * @since  14-01-2018.
 */
@Service
public final class CurrencyRateService {

    @Autowired
    private CurrencyRateRepository currencyRateRepository;

    private static final Logger log = LoggerFactory.getLogger(CurrencyRateService.class);

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void startUpdatingQueue() {
        scheduler.scheduleAtFixedRate(() -> {
            Double dollar = 35.0;
            Double euro = 45.0;
            currencyRateRepository.save(new CurrencyRate(dollar, euro));
            log.info("currency rates updated: dollar={}, euro={}", dollar, euro);
        }, 0, 10, TimeUnit.SECONDS);
    }
}
