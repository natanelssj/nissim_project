package dao;

import dm.Group;

import java.util.*;

public class MembersDao implements IDAO<Integer, Group> {
    private final GroupDao groupDao = new GroupDao();

    @Override
    public void save(Group entity) {
        groupDao.save(entity);
    }

    @Override
    public Group find(Integer id) {
        return groupDao.find(id);
    }

    @Override
    public void delete(Group entity) {
        groupDao.delete(entity);
    }

    @Override
    public List<Group> findAll() {
        return groupDao.findAll();
    }

    @Override
    public void saveAll() {
        groupDao.saveAll();
    }

    @Override
    public void loadAll() {
        groupDao.loadAll();
    }
}
