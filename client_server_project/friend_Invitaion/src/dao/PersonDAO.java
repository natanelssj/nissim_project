/*package dao;

import dm.Person;
import main.java.AlgorithmSearch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PersonDAO implements IDAO.IDao<Integer, Person> {
    private Map<Integer, Person> personStorage = new HashMap<>();


    @Override
    public void delete(Person entity) {

        personStorage.remove(entity.getId());
        System.out.println("Person with ID " + entity.getId() + " deleted.");
    }

    @Override
    public Person find(Integer id) throws IllegalArgumentException, IOException {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null.");
        }
        return personStorage.get(id);
    }

    @Override
    public boolean save(Person entity) throws IllegalArgumentException {
        if (entity == null || entity.getId() == null) {
            throw new IllegalArgumentException("Entity or ID cannot be null.");
        }
        personStorage.put(entity.getId(), entity);
        System.out.println("Person with ID " + entity.getId() + " saved.");
        return true;
    }
}
*/



package dao;

import dm.Person;

import java.util.*;

public class PersonDAO implements IDAO<Integer, Person> {
    private final Map<Integer, Person> personStorage = new HashMap<>();
    private final Map<Integer, List<Integer>> connections = new HashMap<>();

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
    public void save(Person entity) {
        personStorage.put(entity.getId(), entity);
    }

    @Override
    public Person find(Integer id) {
        return personStorage.get(id);
    }

    @Override
    public void delete(Person entity) {
        personStorage.remove(entity.getId());
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(personStorage.values());
    }

    public void addConnection(int person1, int person2) {
        connections.computeIfAbsent(person1, k -> new ArrayList<>()).add(person2);
        connections.computeIfAbsent(person2, k -> new ArrayList<>()).add(person1);
    }

    public Map<Integer, List<Integer>> getConnectionsGraph() {
        return connections;
    }
}
