package dao;

import dm.Group;

import java.io.*;
import java.util.*;

public class GroupDao implements IDAO<Integer, Group> {
    private final Map<Integer, Group> groupStorage = new HashMap<>();
    private final String filePath = "groups.txt";

    @Override
    public void save(Group entity) {
        groupStorage.put(entity.getId(), entity);
        saveAll();
    }

    @Override
    public Group find(Integer id) {
        return groupStorage.get(id);
    }

    @Override
    public void delete(Group entity) {
        groupStorage.remove(entity.getId());
        saveAll();
    }

    @Override
    public List<Group> findAll() {
        return new ArrayList<>(groupStorage.values());
    }

    @Override
    public void saveAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Group group : groupStorage.values()) {
                writer.write(group.getId() + "," + group.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to save groups: " + e.getMessage());
        }
    }

    @Override
    public void loadAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            groupStorage.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                //groupStorage.put(id, new Group(id, name));
            }
        } catch (IOException e) {
            System.err.println("Failed to load groups: " + e.getMessage());
        }
    }
}
