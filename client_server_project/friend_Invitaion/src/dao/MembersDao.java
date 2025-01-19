package dao;

import dm.Group;

import java.util.*;

public class MembersDao implements IDAO {

    private GroupDao groupDAO = new GroupDao(); // To interact with Group entities

    @Override
    public String save() {
        // Take group as input, save it to the file
        // This could be replaced with actual file-saving logic
        return "Group saved successfully";
    }

    @Override
    public String name() {
        return "MembersDao";
    }

    @Override
    public String getById() {
        // Get group from file by id
        // This is a placeholder and should be replaced with actual logic
        return "Group retrieved by ID";
    }

    @Override
    public void save(Object entity) {

    }

    @Override
    public Object find(Object id) {
        return null;
    }

    @Override
    public void delete(Object entity) {

    }

    @Override
    public List findAll() {
        return List.of();
    }

}
