package dao;

import dm.Person;

import java.io.*;
import java.util.*;

public class PersonDAO implements IDAO<Integer, Person> {
    private final Map<Integer, Person> personStorage = new HashMap<>();
    private final String filePath = "persons.txt";

    @Override
    public void save(Person entity) {
        personStorage.put(entity.getId(), entity);
        saveAll();
    }

    @Override
    public Person find(Integer id) {
        return personStorage.get(id);
    }

    @Override
    public void delete(Person entity) {
        personStorage.remove(entity.getId());
        saveAll();
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(personStorage.values());
    }

    @Override
    public void saveAll() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Person person : personStorage.values()) {
                writer.write(person.getId() + "," + person.getName());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Failed to save persons: " + e.getMessage());
        }
    }

    @Override
    public void loadAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            personStorage.clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                personStorage.put(id, new Person(id, name));
            }
        } catch (IOException e) {
            System.err.println("Failed to load persons: " + e.getMessage());
        }
    }

    public void addConnection(int i, int i1) {
    }

    public Map<Integer, List<Integer>> getConnectionsGraph() {
        return null;
    }
}
