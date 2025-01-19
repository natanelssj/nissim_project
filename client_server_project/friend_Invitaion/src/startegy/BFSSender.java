package startegy;

import dao.PersonDAO;
import dm.Person;
import main.java.AlgorithmSearch;
import startegy.ISendStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BFSSender implements ISendStrategy {
    private final PersonDAO personDao;
    private final AlgorithmSearch bfs;

    public BFSSender(PersonDAO personDao, AlgorithmSearch bfs) {
        this.personDao = personDao;
        this.bfs = bfs;
    }

    @Override
    public String send() {
        return "";
    }

    @Override
    public List<Person> sendInvitations(int startUserId, int range) {
        Map<Integer, List<Integer>> graph = personDao.getConnectionsGraph();
        List<Integer> visited = new ArrayList<>();
        bfs.search(graph, startUserId);

        for (Integer id : graph.keySet()) {
            Person person = personDao.find(id);
            if (person != null) {
                visited.add(id);
            }
        }

        return visited.stream().map(personDao::find).toList();
    }
}
