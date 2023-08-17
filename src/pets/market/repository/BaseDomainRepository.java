package pets.market.repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public interface BaseDomainRepository<T, S> {
  Optional<T> findById(S id);

  List<T> findAll();

  List<T> findByPredicate(Predicate<T> tPredicate);

  List<T> saveAll(List<T> list);

  List<T> updateAll(List<T> list);

  T save(T t);

  T update(T t);

  Boolean delete(T t);

  Boolean deleteAll(List<T> list);
}
