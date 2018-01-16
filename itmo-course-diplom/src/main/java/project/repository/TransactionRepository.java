package project.repository;

import org.springframework.data.repository.CrudRepository;
import project.entity.Transaction;

/**
 * Репозиторий для {@link Transaction}
 *
 * @author Egor Stepanov
 * @since  17-01-2018.
 */
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

}
