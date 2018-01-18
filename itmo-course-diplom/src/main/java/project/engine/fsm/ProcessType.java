package project.engine.fsm;

/**
 * Тип процесса
 *
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
public enum ProcessType {

    /**
     * Трансферный процесс
     */
    TRANSFER(1);

    private final int code;

    ProcessType(int code) {
        this.code = code;
    }
}
