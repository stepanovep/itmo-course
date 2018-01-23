package project.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import project.service.LocalDateTimeConverter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Set;


/**
 * Доменная сущность, представляющая элемент таблицы ACCOUNT
 *
 * @author Egor Stepanov
 * @since 12-01-2018.
 */
@Getter
@Setter
@ToString(of = {"name", "contact", "balance"})
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String contact;

    private Double balance;

    @Column(name = "registration_time")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime registrationTime;

    protected Account() {
    }

    public Account(String name, String contact) {
        this.name = name;
        this.contact = contact;
    }

    public Account(String name, String contact, Double balance) {
        this.name = name;
        this.contact = contact;
        this.balance = balance;
    }

    public void withdraw(Double amount) {
        balance -= amount;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "ACCOUNT2TRANSACTIONS",
            joinColumns = { @JoinColumn(name = "id", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "account_from", referencedColumnName = "id") })
    public Set<Transaction> transactions;
}
