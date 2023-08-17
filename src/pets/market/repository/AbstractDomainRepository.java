package pets.market.repository;

import pets.market.dto.DomainType;
import pets.market.dto.DomainWrapperDTO;
import pets.market.service.JsonPersistService;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public abstract class AbstractDomainRepository<T, S> implements BaseDomainRepository<T, S> {

    private final JsonPersistService<T> tJsonPersistService;

    private final List<T> list;

    public AbstractDomainRepository(JsonPersistService<T> tJsonPersistService, List<T> list) {
        this.tJsonPersistService = tJsonPersistService;
        this.list = list;
    }

    @Override
    public Optional<T> findById(S id) {
        return Optional.empty();
    }

    @Override
    public List<T> findAll() {
        return null;
    }

    @Override
    public List<T> findByPredicate(Predicate<T> tPredicate) {
        return null;
    }

    @Override
    public List<T> saveAll(List<T> list) {
        return null;
    }

    @Override
    public List<T> updateAll(List<T> list) {
        return null;
    }

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public T update(T t) {
        return null;
    }

    @Override
    public Boolean delete(T t) {
        return null;
    }

    @Override
    public Boolean deleteAll(List<T> list) {
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


