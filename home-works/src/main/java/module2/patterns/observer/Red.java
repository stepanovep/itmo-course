package module2.patterns.observer;

import org.slf4j.LoggerFactory;

public class Red extends ListenerColor implements Alarm {

    public Red(int criticalTemp) {
        super(criticalTemp);
        logger = LoggerFactory.getLogger(Red.class);
    }

    @Override
    public void tempChanged(int temp) {
        if (!isAlarmed && temp >= criticalTemp) {
            logger.warn("!!Red Alarm!! Critical temperature passed: temp={}", temp);
            isAlarmed = true;
        }
    }
}
