package module2.patterns.observer;

import org.slf4j.LoggerFactory;

public class Yellow extends ListenerColor implements Alarm {

    public Yellow(int criticalTemp) {
        super(criticalTemp);
        logger = LoggerFactory.getLogger(Yellow.class);
    }

    @Override
    public void tempChanged(int temp) {
        if (!isAlarmed && temp >= criticalTemp) {
            logger.warn("!!Yellow Alarm!! Critical temperature passed: temp={}", temp);
            isAlarmed = true;
        }
    }
}
