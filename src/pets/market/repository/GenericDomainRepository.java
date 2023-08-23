package pets.market.repository;

import pets.market.domain.BaseEntity;
import pets.market.service.JOptionPaneWrapper;
import pets.market.service.JOptionPaneWrapperImpl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;

public class GenericDomainRepository<T extends BaseEntity<S>, S> implements BaseDomainRepository<T, S> {
  private final JOptionPaneWrapper gui = new JOptionPaneWrapperImpl();
  private T[] tArray;

  public GenericDomainRepository(T[] tArray) {
    this.tArray = tArray;
  }

  @Override
  public Optional<T> findById(S id) {
    try {
      return Arrays.stream(tArray).filter(t -> t.getId().equals(id)).findFirst();
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
    return Optional.empty();
  }

  @Override
  public T[] findAll() {
    try {
      return tArray;
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
    return null;
  }

  @Override
  public T[] findByPredicate(Predicate<T> tPredicate) {
    try {
      return (T[]) Arrays.stream(tArray).filter(tPredicate).toArray();
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
    return null;
  }

  @Override
  public T save(T t) {
    try {
      if (this.add(t)) {
        return t;
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
    return null;
  }

  @Override
  public Boolean delete(T t) {
    boolean isDeleted = false;
    for (int i = 0; i < tArray.length; i++) {
      if (tArray[i].equals(t)) {
        tArray[i] = null;
        isDeleted = true;
        break;
      }
    }
    return isDeleted;
  }

  private boolean add(T t) {
    boolean isInArray = false;
    try {
      AtomicInteger freeBlockIndex = new AtomicInteger(0);
      if (hasAddressableBlock(freeBlockIndex)) {
        tArray[freeBlockIndex.get()] = t;
        isInArray = true;
      } else {
        if (addWithNewArray(t)) {
          isInArray = true;
        }
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
    return isInArray;
  }

  private boolean hasAddressableBlock(AtomicInteger freeBlockIndex) {
    boolean hasSpace = false;
    try {
      for (int i = 0; i < tArray.length; i++) {
        if (tArray[i] == null) {
          hasSpace = true;
          freeBlockIndex.set(i);
          break;
        }
      }
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
    return hasSpace;
  }

  private boolean addWithNewArray(T t) {
    boolean addedWithNewArray = false;
    try {
      T[] tempArray = (T[]) Array.newInstance(t.getClass(), (tArray.length + 10));
      System.arraycopy(tArray, 0, tempArray, 0, tArray.length);
      tempArray[tArray.length] = t;
      tArray = tempArray;
      addedWithNewArray = true;
    } catch (Exception e) {
      gui.doShowErrorData(e.getMessage());
    }
    return addedWithNewArray;
  }
}


