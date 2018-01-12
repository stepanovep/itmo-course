package project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.entity.Account;

/**
 * @author Egor Stepanov
 * @since 12-01-2018.
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
