package project.engine.fsm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
@Component
public class TransferProcessExecutor implements ProcessExecutor<Process<TransferContext>> {

    private static final Logger log = LoggerFactory.getLogger(TransferProcessExecutor.class);

    @Nonnull
    @Override
    public ProcessType getProcessType() {
        return ProcessType.TRANSFER;
    }

    @Override
    public void execute(@Nonnull Process<TransferContext> process) {
        Objects.requireNonNull(process, "process");
        TransferContext ctx = process.getProcessCtx();

        if (ctx.getStage() == TransferStage.STAGE_1) {
            log.info("Executing stage: {}", ctx.getStage());
        }

        if (ctx.getStage() == TransferStage.STAGE_2) {
            log.info("Executing stage: {}", ctx.getStage());
        }

        if (ctx.getStage() == TransferStage.SUCCESS) {
            log.info("Transfer process has finished successfully");
        }

        else if (ctx.getStage() == TransferStage.FAILED) {
            log.info("Transfer process terminated with errors");
        }

        else {
            log.error("Inconsistent process state. Check the logic of State Machine. Process={}", process);
        }
    }
}
