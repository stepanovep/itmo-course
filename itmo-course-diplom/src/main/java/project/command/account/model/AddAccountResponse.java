package project.command.account.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * Результат команды добавления нового аккаунта
 *
 * @author Egor Stepanov
 * @since 19-01-2018.
 */
@Getter
@Builder
@ToString
public class AddAccountResponse {

    @JsonProperty("id")
    private final Long id;

    @JsonProperty("name")
    private final String name;

    @JsonProperty("contact")
    private final String contact;

    @JsonProperty("balance")
    private final Double balance;

    @JsonCreator
    public AddAccountResponse(@Nonnull @JsonProperty("id") Long id,
                              @Nonnull @JsonProperty("name") String name,
                              @Nonnull @JsonProperty("contact") String contact,
                              @Nonnull @JsonProperty("balance") Double balance) {

        this.id = Objects.requireNonNull(id, "id");
        this.name = Objects.requireNonNull(name, "name");
        this.contact = Objects.requireNonNull(contact, "contact");
        this.balance = Objects.requireNonNull(balance, "balance");
    }
}
