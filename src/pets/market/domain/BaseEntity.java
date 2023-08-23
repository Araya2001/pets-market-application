package pets.market.domain;

public abstract class BaseEntity<S> {
  protected S id;

  public S getId() {
    return id;
  }

  public BaseEntity<S> setId(S id) {
    this.id = id;
    return this;
  }
}
