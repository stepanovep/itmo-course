package project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Egor Stepanov
 * @since 12-01-2018.
 */
@Data
@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private String name;

    private String email;

    protected Account() {
    }

    public Account(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

