package sdomain.dao;

import java.util.List;

public interface Dao<T> {

    List<T> getAll();

    T getByID(int id);

}
