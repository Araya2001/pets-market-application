package pets.market.dto;

import java.time.Instant;
import java.util.List;

public class DomainWrapperDTO<T> {
  private Instant timestamp;
  private List<T> data;
  private Long counter;
  private DomainType domainType;

  public Instant getTimestamp() {
    return timestamp;
  }

  public DomainWrapperDTO<T> setTimestamp(Instant timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  public List<T> getData() {
    return data;
  }

  public DomainWrapperDTO<T> setData(List<T> data) {
    this.data = data;
    return this;
  }

  public Long getCounter() {
    return counter;
  }

  public DomainWrapperDTO<T> setCounter(Long counter) {
    this.counter = counter;
    return this;
  }

  public DomainType getDomainType() {
    return domainType;
  }

  public DomainWrapperDTO<T> setDomainType(DomainType domainType) {
    this.domainType = domainType;
    return this;
  }
}
