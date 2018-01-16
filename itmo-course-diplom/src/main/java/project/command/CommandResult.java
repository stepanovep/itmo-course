package project.command;


import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;
import java.util.Optional;

/**
 * Результат выполнения {@link Command}
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
public final class CommandResult<T> {

    @Nonnull
    private final Status status;

    @Nullable
    private final T result;

    @Nullable
    private final String comment;

    public CommandResult(@Nonnull Status status,
                         @Nullable T result,
                         @Nullable String comment) {
        this.status = Objects.requireNonNull(status, "status");
        this.result = result;
        this.comment = comment;
    }

    @Nonnull
    public Status getStatus() {
        return status;
    }

    @Nonnull
    public Optional<T> getResult() {
        return Optional.ofNullable(result);
    }

    @Nonnull
    public Optional<String> getComment() {
        return Optional.ofNullable(comment);
    }

    public enum Status {
        SUCCESS,
        PROGRESS,
        ERROR
    }

    /**
     * Вернуть SUCCESS результат с телом ответа
     */
    public static <U> CommandResult<U> success(@Nullable U result) {
        return new CommandResult<>(Status.SUCCESS, result, null);
    }

    /**
     * Вернуть ERROR результат с пояснением ошибки
     */
    public static <U> CommandResult<U> error(@Nullable String comment) {
        return new CommandResult<>(Status.ERROR, null, comment);
    }

    @Override
    public String toString() {
        return "CommandResult{" +
                "status=" + status +
                ", result=" + result +
                ", comment='" + comment + '\'' +
                '}';
    }
}
