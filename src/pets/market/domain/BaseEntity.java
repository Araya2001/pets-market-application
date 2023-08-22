package pets.market.domain;

public abstract class BaseEntity<S> {
  private S id;

  public S getId() {
    return id;
  }

  public BaseEntity<S> setId(S id) {
    this.id = id;
    return this;
  }
}
