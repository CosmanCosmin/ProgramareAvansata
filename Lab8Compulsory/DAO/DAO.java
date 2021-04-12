package DAO;

import java.util.List;

public interface DAO<T> {
    T get(int id);
    List<T> getByName(String name);
    List<T> getAll();
    void add(T t);
}
