package ua.org.oa._dani4_.dao;

import java.util.List;

/**
 * Created by _dani on 30.03.2016.
 */

public interface Dao<T> {
    T create(T t);
    T read(int index);
    List<T> getAll();
    boolean update(int index, T t);
    boolean delete(int index);
}