package homework7.lazyAccumulator;

import homework7.iterablelist.Stack;
import homework7.lazyAccumulator.LazyAccumulator.Operation;

/**
 * @author Egor Stepanov
 * @since  26-10-2017.
 */
public class LazyAccumulatorStack {

    private Stack<Operation> operations;
    private int value;

    public LazyAccumulatorStack(Stack<Operation> operations, int initialValue) {
        this.operations = operations;
        this.value = initialValue;
    }

    public void add(int a, Operation operation) {
        operation.setArgument(a);
        operations.push(operation);
    }

    public int calculate() {
        Operation operation;
        while (operations.top() != null) {
            operation = operations.pop();
            value = operation.apply(value, operation.getArgument());
        }
        return value;
    }
}
