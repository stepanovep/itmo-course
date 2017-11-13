package module1.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Egor Stepanov
 * @since  12-11-2017.
 */
public class Calculator {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private static Pattern assignmentExpression = Pattern.compile("([xy])([=])([0-9]+)");
    private static Pattern binaryExpression = Pattern.compile("([xy]|[0-9]+)([-+/*])([xy]|[0-9]+)");

    public int execute(String command) {
        command = command.replace(" ", "");
        Matcher assignmentMatcher = assignmentExpression.matcher(command);
        Matcher binaryOpMatcher = binaryExpression.matcher(command);

        if (assignmentMatcher.matches()) {
            String[] args = command.split("=");

            String arg1 = args[0];
            String arg2 = args[1];

            int value = Integer.valueOf(arg2);
            switch (arg1) {
                case "x":
                    x = value;
                    break;
                case "y":
                    y = value;
                    break;
                default:
                    throw new IllegalArgumentException("First argument must be x or y");
            }
            System.out.println("value successfully assigned");
            return value;

        } else if (binaryOpMatcher.matches()) {
            String[] args = command.split("[-+/*]");
            int arg1 = getArgValue(args[0]);
            int arg2 = getArgValue(args[1]);
            Operation operation = Operation.byCode(binaryOpMatcher.group(2));

            int ans;
            switch (operation) {
                case PLUS:
                    ans = arg1 + arg2;
                    break;
                case MINUS:
                    ans = arg1 - arg2;
                    break;
                case MULTIPLY:
                    ans = arg1 * arg2;
                    break;
                case DIVIDE:
                    ans = arg1 / arg2;
                    break;
                default:
                    throw new IllegalStateException("Unknown operation: " + operation);
            }
            System.out.println("result of operation: " + ans);
            return ans;

        } else {
            throw new IllegalArgumentException("Expected exactly 2 arguments - expression in format: [x = y] or [x op = y]");
        }
    }

    private int getArgValue(String arg) {
        switch (arg) {
            case "x":
                return x;
            case "y":
                return y;
            default:
                return Integer.valueOf(arg);
        }
    }
}
