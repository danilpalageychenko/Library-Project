package ua.org.oa._dani4_.service;

import java.util.List;

/**
 * Created by Admin on 03.04.2016.
 */
public interface IBookService<T1> {
    T1 findById(int id);
    int create(T1 t1);
    boolean update (T1 t1);
    List<T1> getAll();
    boolean delete(int id);

}