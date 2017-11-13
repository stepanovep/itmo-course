package module1.calculator;

/**
 * @author Egor Stepanov
 * @since 12-11-2017.
 */
public enum Operation {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    private final String code;

    Operation(String code) {
        this.code = code;
    }

    public static Operation byCode(String code) {
        switch (code) {
            case "+":
                return PLUS;
            case "-":
                return MINUS;
            case "*":
                return MULTIPLY;
            case "/":
                return DIVIDE;
            default:
                throw new IllegalStateException("Unknown operation: " + code);
        }
    }
}
