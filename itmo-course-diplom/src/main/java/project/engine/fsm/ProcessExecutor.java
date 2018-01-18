package project.engine.fsm;

import javax.annotation.Nonnull;

/**
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
public interface ProcessExecutor<ProcessT extends Process<? extends ProcessContext<? extends  ProcessStage>>> {

    /**
     * Тип процесса
     */
    @Nonnull
    ProcessType getProcessType();

    /**
     * Исполнить процесс
     */
    void execute(@Nonnull ProcessT process);
}
