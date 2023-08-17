package pets.market.service;

import pets.market.dto.DomainWrapperDTO;

public interface JsonPersistService<T> {
  Boolean writeToFile(DomainWrapperDTO<T> t, String fileName);

  DomainWrapperDTO<T> readFromFile(String fileName);
}
