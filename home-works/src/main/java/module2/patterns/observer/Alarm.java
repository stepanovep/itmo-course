package module2.patterns.observer;

/**
 * Итерфейс для слушателя
 */
public interface Alarm {
    /**
     * Увелечение температуры
     */
    void tempChanged(int temp);
}
