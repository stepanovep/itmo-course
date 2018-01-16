package project.command;

/**
 * Интерфейс Command
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@FunctionalInterface
public interface Command<RequestT, ResponseT> {

    /**
     * Execute a command
     */
    CommandResult<ResponseT> execute(RequestT requestT);
}
