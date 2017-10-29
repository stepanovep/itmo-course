package module1.accumulator;

import module1.accumulator.operation.Operation;

/**
 * @author Egor Stepanov
 * @since 20/10/2017.
 */
public class Accumulator {

    private int value;
    private final Operation operation;

    public Accumulator(int value, Operation operation) {
        this.value = value;
        this.operation = operation;
    }

    public void accumulate(int p) {
        value =  operation.doOperation(value, p);
    }

    public int getValue() {
        return value;
    }

    public Operation getOperation() {
        return operation;
    }
}
