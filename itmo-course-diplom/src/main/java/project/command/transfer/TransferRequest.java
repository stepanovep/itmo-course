package project.command.transfer;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * Запрос для команды перевода средств
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Getter
@Builder
@ToString
public class TransferRequest {

    @Nonnull
    @JsonProperty("accountIdFrom")
    private final Long accountIdFrom;

    @Nonnull
    @JsonProperty("accountIdTo")
    private final Long accountIdTo;

    @Nonnull
    @JsonProperty("amount")
    private final Double amount;

    @JsonCreator
    private TransferRequest(@Nonnull @JsonProperty("accountIdFrom") Long accountIdFrom,
                           @Nonnull @JsonProperty("accountIdTo") Long accountIdTo,
                           @Nonnull @JsonProperty("amount") Double amount) {
        this.accountIdFrom = Objects.requireNonNull(accountIdFrom, "accountIdFrom");
        this.accountIdTo = Objects.requireNonNull(accountIdTo, "accountIdTo");
        this.amount = amount;
    }
}
