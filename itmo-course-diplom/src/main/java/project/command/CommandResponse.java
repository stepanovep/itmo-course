package project.command;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Результат выполнения {@link Command}
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Builder
public final class CommandResponse<T> {

    @Nonnull
    private final Status status;

    @Nullable
    private final T result;

    @Nullable
    private final String errorMessage;

    @JsonCreator
    public CommandResponse(@Nonnull @JsonProperty("status") Status status,
                           @Nullable @JsonProperty("result") T result,
                           @Nullable @JsonProperty("errorMessage") String errorMessage) {
        this.status = Objects.requireNonNull(status, "status");
        this.result = result;
        this.errorMessage = errorMessage;
    }

    @Nonnull
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @Nullable
    @JsonProperty("result")
    public T getResult() {
        return result;
    }

    @Nullable
    @JsonProperty("errorMessage")
    public String getErrorMessage() {
        return errorMessage;
    }

    public enum Status {
        @JsonProperty("success")
        SUCCESS,

        @JsonProperty("progress")
        PROGRESS,

        @JsonProperty("error")
        ERROR
    }

    /**
     * Вернуть SUCCESS результат с телом ответа
     */
    public static <U> CommandResponse<U> success(@Nullable U result) {
        return CommandResponse.<U>builder()
                .status(Status.SUCCESS)
                .result(result)
                .build();
    }

    /**
     * Вернуть SUCCESS результат с пустым телом
     */
    public static CommandResponse success() {
        return CommandResponse.builder()
                .status(Status.SUCCESS)
                .build();
    }

    /**
     * Вернуть ERROR результат с описанием ошибки
     */
    public static <U> CommandResponse<U> error(@Nullable String errorMessage) {
        return CommandResponse.<U>builder()
                .status(Status.ERROR)
                .errorMessage(errorMessage)
                .build();
    }

    @Override
    public String toString() {
        return "CommandResponse{" +
                "status=" + status +
                ", result=" + result +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
