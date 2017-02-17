package sdomain.dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    T getByID(String id);

    void update(T receipt);

    void delete(String id);

    void create(T receipt);

}
