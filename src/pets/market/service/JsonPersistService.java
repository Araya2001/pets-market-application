package pets.market.service;

public interface JsonPersistService<T> {
    Boolean writeToFile(T t, String fileName);

   T readFromFile(String fileName);
}
