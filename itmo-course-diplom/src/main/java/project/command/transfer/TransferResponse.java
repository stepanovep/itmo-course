package project.command.transfer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.annotation.Nullable;

/**
 * Результат команды {@link TransferCommand}
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Getter
@Builder
@ToString
public class TransferResponse {

    @Nullable
    @JsonProperty("comment")
    private final String comment;

    @JsonCreator
    private TransferResponse(@Nullable @JsonProperty("comment") String comment) {
        this.comment = comment;
    }
}
