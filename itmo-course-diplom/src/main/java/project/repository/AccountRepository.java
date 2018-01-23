package project.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import project.entity.Account;

/**
 * Репозиторий для {@link Account}
 *
 * @author Egor Stepanov
 * @since  12-01-2018.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    @Query("select a from Account a where a.name = :name")
    Account findAccountByName(@Param("name") String name);

    @Query("select count(a) > 0 from Account a where a.name = :name")
    boolean isExistsByName(@Param("name") String name);

    @Query("select a from Account a where a.contact = :contact")
    Account findAccountByContact(@Param("contact") String contact);

    @Query("select count(a) > 0 from Account a where a.contact = :contact")
    boolean isExistsByContact(@Param("contact") String contact);

    @Query("select count(a) > 0 from Account a where a.name = :name or a.contact = :contact")
    boolean isExists(@Param("name") String name, @Param("contact") String contact);

    @Modifying(clearAutomatically = true)
    @Query("update Account a set a.name = :name, a.contact = :contact where a.id = :id")
    void updateAccount(@Param("id") Long id, @Param("name") String name, @Param("contact") String contact);

    @Query("update Account a set a.balance = :balance where a.id = :id")
    @Modifying
    void setBalance(@Param("id") Long id, @Param("balance") Double balance);
}
