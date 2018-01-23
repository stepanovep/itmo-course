package project.command.account.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Objects;

/**
 * Запрос на обновление данных аккаунта
 *
 * @author Egor Stepanov
 * @since 19-01-2018.
 */
@Getter
@Builder
@ToString
public class UpdateAccountRequest {

    @Nonnull
    @JsonProperty("id")
    private final Long id;

    @Nullable
    @JsonProperty("newName")
    private final String newName;

    @Nullable
    @JsonProperty("newContact")
    private final String newContact;

    @JsonCreator
    public UpdateAccountRequest(@Nonnull @JsonProperty("id") Long id,
                                @Nullable @JsonProperty("newName") String newName,
                                @Nullable @JsonProperty("newContact") String newContact) {
        this.id = Objects.requireNonNull(id, "id is mandatory");
        this.newName = newName;
        this.newContact = newContact;
    }

}
