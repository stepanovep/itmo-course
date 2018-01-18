package project.engine.fsm;

/**
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
public class TransferContext implements ProcessContext<TransferStage> {

    private TransferStage stage;

    private TransferContext() {
        stage = TransferStage.STAGE_1;
    }

    public static TransferContext createContext() {
        return new TransferContext();
    }

    @Override
    public ProcessType getType() {
        return ProcessType.TRANSFER;
    }

    @Override
    public TransferStage getStage() {
        return stage;
    }

}
