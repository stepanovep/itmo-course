package homework7.lazyAccumulator;

import homework7.iterablelist.List;

/**
 * @author Egor Stepanov
 * @since  26-10-2017.
 */
public class LazyAccumulator {

    private List<Operation> operations;
    private int value;

    public LazyAccumulator(List<Operation> operations, int initialValue) {
        this.operations = operations;
        this.value = initialValue;
    }

    public void add(int a, Operation operation) {
        operation.setArgument(a);
        operations.add(operation);
    }

    public int calculate() {
        for (Operation operation: operations) {
            value = operation.apply(value, operation.getArgument());
        }
        return value;
    }

    public interface Operation {
        void setArgument(int y); // похоже на говнокод, как можно хранить состояние у Operation? А надо ли?
        int getArgument();
        int apply(int x, int y);
    }
}
