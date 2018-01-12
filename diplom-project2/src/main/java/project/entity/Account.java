package project.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Egor Stepanov
 * @since 12-01-2018.
 */
@Entity
@Table
@Data
@EqualsAndHashCode(of = {"name, email"})
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String name;

    private String email;

    protected Account() {
    }

    public Account(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
