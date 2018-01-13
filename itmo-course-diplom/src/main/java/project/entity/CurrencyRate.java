package project.entity;

import lombok.Data;

import javax.annotation.Nonnull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @author Egor Stepanov
 * @since  14-01-2018.
 */
@Data
@Entity
@Table(name = "currency_rate")
public class CurrencyRate {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private Double dollar;

    private Double euro;

    protected CurrencyRate() {
    }

    public CurrencyRate(@Nonnull Double dollar,
                        @Nonnull Double euro) {
        this.dollar = Objects.requireNonNull(dollar, "dollar");
        this.euro = Objects.requireNonNull(euro, "euro");
    }
}
