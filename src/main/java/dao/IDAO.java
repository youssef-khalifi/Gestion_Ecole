package dao;

import java.util.List;

public interface IDAO <T>{
    boolean saveOrUpdate(T t);
    boolean create(T t);
    boolean update(T t);
    T findById(Integer id);
    List<T> getAll();
    boolean delete(T t);

}
