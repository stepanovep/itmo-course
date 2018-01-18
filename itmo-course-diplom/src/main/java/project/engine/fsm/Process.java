package project.engine.fsm;

import lombok.Getter;
import lombok.ToString;

/**
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
@Getter
@ToString
public class Process<ProcessContextT extends ProcessContext<? extends ProcessStage>> {

    private final ProcessContextT processCtx;
    private final Long processId;

    public Process(ProcessContextT processCtx, Long processId) {
        this.processCtx = processCtx;
        this.processId = processId;
    }
}
