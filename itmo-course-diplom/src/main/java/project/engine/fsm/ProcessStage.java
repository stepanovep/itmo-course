package project.engine.fsm;

/**
 * Стэйдж процесса (конечного автомата)
 *
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
public interface ProcessStage {

    /**
     * Числовой код стэйджа
     */
    int getCode();

    /**
     * Описание стэйджа
     */
    String getDescription();
}
