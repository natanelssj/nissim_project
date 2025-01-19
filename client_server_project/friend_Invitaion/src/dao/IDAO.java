package dao;
import java.util.*;
import java.io.IOException;

public interface IDAO <K, V> {
    String save();

    String name();

    String getById();

    void save(V entity);
    V find(K id);
    void delete(V entity);
    List<V> findAll();
}

