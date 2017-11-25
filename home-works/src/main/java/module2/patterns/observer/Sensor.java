package module2.patterns.observer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sensor {

    private static final Logger logger = LoggerFactory.getLogger(Sensor.class);

    private int temp = 0;
    private int dxTemp = 50;
    private List<Alarm> listeners;

    public Sensor(int initTemp, int dxTemp) {
        this.temp = initTemp;
        this.dxTemp = dxTemp;
        listeners = new ArrayList<>();
        logger.info("Sensor initialized: temperature is {}, inc temp step is", temp, dxTemp);
    }

    public void addListener(Alarm ... alarms) {
        listeners.addAll(Arrays.asList(alarms));
    }

    public void removeListener(Alarm alarm) {
        listeners.remove(alarm);
    }

    public void incrementTemp() {
        temp += dxTemp;
        logger.info("Current temperature is {}", temp);
        for (Alarm alarm: listeners) {
            alarm.tempChanged(temp);
        }
    }
}
