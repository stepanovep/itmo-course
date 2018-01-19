package project.engine.fsm;

import project.command.transfer.TransferRequest;

/**
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
public class TransferContext implements ProcessContext<TransferStage> {

    private TransferStage stage;

    private TransferRequest request;

    private String errorMessage;

    private TransferContext() {
        stage = TransferStage.VALIDATE_CONTEXT;
    }

    public static TransferContext createContext() {
        return new TransferContext();
    }

    public void setRequest(TransferRequest request) {
        this.request = request;
    }

    public TransferRequest getRequest() {
        return request;
    }

    @Override
    public ProcessType getType() {
        return ProcessType.TRANSFER;
    }

    @Override
    public TransferStage getStage() {
        return stage;
    }

    @Override
    public void setStage(TransferStage stage) {
        this.stage = stage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
