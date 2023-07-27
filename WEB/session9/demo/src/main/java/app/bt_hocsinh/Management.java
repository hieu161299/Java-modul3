package app.bt_hocsinh;

import java.util.List;

public interface Management<E> {
    void add(E e) ;
    void delete(int index, E e);
    int findIndex(int index);
    List<E> getAll();
}
