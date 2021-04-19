package DAO;

import java.util.List;

public interface DAO<T> {
    T get(String id);
    List<T> getByName(String name);
    List<T> getAll();
    void add(T t);
}
