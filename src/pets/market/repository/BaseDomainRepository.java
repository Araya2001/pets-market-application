package pets.market.repository;

import java.util.Optional;
import java.util.function.Predicate;

public interface BaseDomainRepository<T, S> {
  Optional<T> findById(S id);

  T[] findAll();

  T[] findByPredicate(Predicate<T> tPredicate);

  T save(T t);

  Boolean delete(T t);
}
