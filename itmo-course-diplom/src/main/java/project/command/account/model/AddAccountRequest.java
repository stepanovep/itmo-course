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
 * Запрос на добавление нового аккаунта в систему
 *
 * @author Egor Stepanov
 * @since 19-01-2018.
 */
@Getter
@Builder
@ToString
public class AddAccountRequest {

    @Nonnull
    @JsonProperty("name")
    private final String name;

    @Nonnull
    @JsonProperty("contact")
    private final String contact;

    @Nullable
    @JsonProperty("initialBalance")
    private final Double initialBalance;

    @JsonCreator
    public AddAccountRequest(@Nonnull @JsonProperty("name") String name,
                             @Nonnull @JsonProperty("contact") String contact,
                             @Nullable @JsonProperty("initialBalance") Double initialBalance) {
        this.name = Objects.requireNonNull(name, "name");
        this.contact = Objects.requireNonNull(contact, "contact");
        this.initialBalance = initialBalance;
    }
}
