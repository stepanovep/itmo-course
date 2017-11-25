package module2.patterns.observer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ListenerColor {

    Logger logger;
    final int criticalTemp;
    boolean isAlarmed;

    ListenerColor(int criticalTemp) {
        this.criticalTemp = criticalTemp;
        this.logger = LoggerFactory.getLogger(ListenerColor.class);
    }
}
