package pets.market.repository;

import pets.market.domain.BaseEntity;
import pets.market.dto.DomainType;
import pets.market.dto.DomainWrapperDTO;
import pets.market.service.JOptionPaneWrapper;
import pets.market.service.JOptionPaneWrapperImpl;
import pets.market.service.JsonPersistService;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Predicate;

public class GenericDomainRepository<T extends BaseEntity<S>, S> implements BaseDomainRepository<T, S> {
  private final JsonPersistService<T> tJsonPersistService;
  private final JOptionPaneWrapper window = new JOptionPaneWrapperImpl();
  private final List<T> list;

  public GenericDomainRepository(JsonPersistService<T> tJsonPersistService, List<T> list) {
    this.tJsonPersistService = tJsonPersistService;
    this.list = list;
  }

  @Override
  public Optional<T> findById(S id) {
    try {
      return list.stream().filter(t -> t.getId().equals(id)).findFirst();
    } catch (Exception e) {
      window.doShowErrorData(e.getMessage());
    }
    return Optional.empty();
  }

  @Override
  public List<T> findAll() {
    try {
      return list;
    } catch (Exception e) {
      window.doShowErrorData(e.getMessage());
    }
    return null;
  }

  @Override
  public List<T> findByPredicate(Predicate<T> tPredicate) {
    try {
      return list.stream().filter(tPredicate).toList();
    } catch (Exception e) {
      window.doShowErrorData(e.getMessage());
    }
    return null;
  }

  @Override
  public List<T> saveAll(List<T> list) {
    try {
      this.list.addAll(list);
      return list;
    } catch (Exception e) {
      window.doShowErrorData(e.getMessage());
    }
    return null;
  }

  @Override
  public List<T> updateAll(List<T> list) {
    try {
      this.list.addAll(list.stream().filter(t -> t.getId() != null).toList());
      return list.stream().filter(t -> t.getId() != null).toList();
    } catch (Exception e) {
      window.doShowErrorData(e.getMessage());
    }
    return null;
  }

  @Override
  public T save(T t) {
    try {
      this.list.add(t);
      return t;
    } catch (Exception e) {
      window.doShowErrorData(e.getMessage());
    }
    return null;
  }

  @Override
  public T update(T t) {
    try {
      if (t.getId() != null) {
        this.list.add(t);
        return t;
      }
    } catch (Exception e) {
      window.doShowErrorData(e.getMessage());
    }
    return null;
  }

  @Override
  public Boolean delete(T t) {
    AtomicBoolean result = new AtomicBoolean(false);
    list.stream().filter(t1 -> t1.getId().equals(t.getId())).findFirst().ifPresent(t1 -> {
      list.remove(t1);
      result.set(true);
    });
    return result.get();
  }

  @Override
  public Boolean deleteAll(List<T> list) {
    try {
      list.forEach(t -> this.list.stream().filter(t1 -> t1.getId().equals(t.getId())).forEach(this.list::remove));
    } catch (Exception e) {
      window.doShowErrorData(e.getMessage());
    }
    return null;
  }

  public void init(Class<T> tClass) {
    list.addAll(tJsonPersistService.readFromFile(tClass.getName()).getData());
  }

  public void writeToFile(Class<T> tClass) {
    tJsonPersistService.writeToFile(new DomainWrapperDTO<T>()
        .setDomainType(DomainType.findByPredicate(domainType -> domainType.getaClass().equals(tClass)).get(0))
        .setData(list)
        .setCounter(Integer.toUnsignedLong(list.size()))
        .setTimestamp(Instant.now()), tClass.getName());
  }
}


