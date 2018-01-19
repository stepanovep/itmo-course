package project.command.account.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.annotation.Nullable;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * Запрос на удаление аккаунта
 *
 * @author Egor Stepanov
 * @since 19-01-2018.
 */
@Getter
@Builder
@ToString
public class DeleteAccountRequest {

    @Nullable
    @JsonProperty("id")
    private final Long id;

    @Nullable
    @JsonProperty("name")
    private final String name;

    @Nullable
    @JsonProperty("contact")
    private final String contact;

    @JsonCreator
    public DeleteAccountRequest(@Nullable @JsonProperty("id") Long id,
                                @Nullable @JsonProperty("name") String name,
                                @Nullable @JsonProperty("contact") String contact) {

        if (Stream.of(id, name, contact)
                .filter(Objects::nonNull)
                .count() == 0) {
            throw new NullPointerException("at least of the arguments must present");
        }
        this.id = id;
        this.name = name;
        this.contact = contact;
    }
}
