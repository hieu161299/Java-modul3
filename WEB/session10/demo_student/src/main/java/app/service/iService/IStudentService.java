package app.service.iService;

import java.util.List;

public interface IStudentService<E> {
    void add(E e);
    int findById(int id);
    void edit(int id , E e);
    void delete(int id);
    List<E> findAll();
}
