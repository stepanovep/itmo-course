package project.engine.fsm;

/**
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
public interface ProcessContext<StageT extends ProcessStage> {

    /**
     * Тип процесса
     */
    ProcessType getType();

    /**
     * Текущий стэйдж процесса
     */
    StageT getStage();
}
