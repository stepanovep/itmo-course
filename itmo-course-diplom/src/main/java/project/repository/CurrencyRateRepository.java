package project.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.entity.CurrencyRate;

/**
 * Репозиторий для {@link CurrencyRate}
 *
 * @author Egor Stepanov
 * @since  14-01-2018.
 */
@Repository
public interface CurrencyRateRepository extends CrudRepository<CurrencyRate, Long> {

    @Query("select c from CurrencyRate c where c.id = (select max(id) from CurrencyRate)")
    CurrencyRate getCurrencyRate();
}
