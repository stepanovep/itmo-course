package project.engine.fsm;

/**
 * Стэйдж для процесса перевода
 *
 * @author Egor Stepanov
 * @since 18-01-2018.
 */
public enum TransferStage implements ProcessStage {

    /**
     * Шаг валидации контекста
     */
     VALIDATE_CONTEXT(10, "validateContext", State.ROLL),

     /**
     * Шаг перевода средств от отправителя в банк
     */
    TRANFSER_PAYER_TO_GATE(20, "transferPayerToGate", State.ROLL),

    /**
     * Шаг перевода средств от банка к получателю
     */
    TRANSFER_GATE_TO_RECIPIENT(30, "transferGateToRecipient", State.ROLL),

    /**
     * Шаг сохранения истории о транзакции в базу
     */
    INSERT_TRANSACTION(40, "insertTransaction", State.ROLL),

    /**
     * Процесс завершен с успехом
     */
    SUCCESS(1000, "success", State.SUCCESS),

    /**
     * Процесс завершен с ошибкой
     */
    FAILED(-1, "failed", State.FAIL);

    private final int code;
    private final String secondaryCode;


    TransferStage(int code, String secondaryCode, State state) {
        this.code = code;
        this.secondaryCode = secondaryCode;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDescription() {
        return secondaryCode;
    }

    @Override
    public String toString() {
        return "TransferStage{" + secondaryCode + '\'' + '}';
    }

    /**
     * Состояние стэйджа
     */
    public enum State {
        /**
         * Конечное состояние - успех
         */
        SUCCESS,

        /**
         * Промежуточное состояние
         */
        ROLL,

        /**
         * Конечное состояние - неуспех
         */
        FAIL
    }
}
