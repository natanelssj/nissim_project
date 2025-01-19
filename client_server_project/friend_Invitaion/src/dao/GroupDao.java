package dao;

import dm.Group;

import java.util.*;

public class GroupDao implements IDAO<Integer, Group> {
    private final Map<Integer, Group> groupStorage = new HashMap<>();

    @Override
    public String save() {
        return "";
    }

    @Override
    public String name() {
        return "";
    }

    @Override
    public String getById() {
        return "";
    }

    @Override
    public void save(Group entity) {
        groupStorage.put(entity.getId(), entity);
    }

    @Override
    public Group find(Integer id) {
        return groupStorage.get(id);
    }

    @Override
    public void delete(Group entity) {
        groupStorage.remove(entity.getId());
    }

    @Override
    public List<Group> findAll() {
        return new ArrayList<>(groupStorage.values());
    }
}
