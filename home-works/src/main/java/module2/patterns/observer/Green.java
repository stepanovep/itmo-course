package module2.patterns.observer;

import org.slf4j.LoggerFactory;

public class Green extends ListenerColor implements Alarm {

    public Green(int criticalTemp) {
        super(criticalTemp);
        logger = LoggerFactory.getLogger(Green.class);
    }


    @Override
    public void tempChanged(int temp) {
        if (!isAlarmed && temp >= criticalTemp) {
            logger.warn("!!Green Alarm!! Critical temperature passed: temp={}", temp);
            isAlarmed = true;
        }
    }
}
