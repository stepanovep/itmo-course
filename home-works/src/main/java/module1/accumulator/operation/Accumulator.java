package module1.accumulator.operation;

/**
 * @author Egor Stepanov
 * @since 20/10/2017.
 */
public class Accumulator {

    private int value;
    private final Operation operation;

    Accumulator(int value, Operation operation) {
        this.value = value;
        this.operation = operation;
    }

    void accumulate(int p) {
        value =  operation.doOperation(value, p);
    }

    int getValue() {
        return value;
    }

    public Operation getOperation() {
        return operation;
    }
}
