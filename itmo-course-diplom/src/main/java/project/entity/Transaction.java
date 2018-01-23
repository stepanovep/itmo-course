package project.entity;

import lombok.Getter;
import lombok.Setter;
import project.service.LocalDateTimeConverter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Доменная сущность, представляющая элемент таблицы TRANSACTION
 *
 * @author Egor Stepanov
 * @since  13-01-2018.
 */
@Getter
@Setter
@Entity
@Table(name = "TRANSACTION")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "account_from")
    private long accountFrom;

    @Column(name = "account_to")
    private long accountTo;

    private double amount;

    @Column(name = "date_time")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime dateTime;

    private boolean refunded;

    protected Transaction() {
    }

    public Transaction(long accountFrom, long accountTo, double amount, LocalDateTime dateTime) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.dateTime = dateTime;
    }
}
