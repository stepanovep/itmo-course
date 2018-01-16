package project.repository;

import org.springframework.data.repository.CrudRepository;
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

}
