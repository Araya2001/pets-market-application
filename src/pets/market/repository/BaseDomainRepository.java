package pets.market.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface BaseDomainRepository<T, S> {
  Optional<T> findById(S id);

  T[] findAll();

  List<T> findByPredicate(Predicate<T> tPredicate);

  T save(T t);

  Boolean delete(T t);
}
