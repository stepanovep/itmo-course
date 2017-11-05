package module1.accumulator.lazy;

import module1.accumulator.lazy.LazyAccumulator.Operation;
import module1.collections.list.LinkedList;
import module1.collections.list.Stack;

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
        Stack<Operation> rightOperations = new LinkedList<>();
        Operation operation;

        while (operations.top() != null) {
            operation = operations.pop();
            rightOperations.push(operation);
        }

        while (rightOperations.top() != null) {
            operation = rightOperations.pop();
            value = operation.apply(value, operation.getArgument());
        }
        return value;
    }
}
