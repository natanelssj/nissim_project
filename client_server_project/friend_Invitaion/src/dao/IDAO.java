package dao;

import java.util.List;

public interface IDAO<K, V> {
    void save(V entity);
    V find(K id);
    void delete(V entity);
    List<V> findAll();
    void saveAll();
    void loadAll();
}
