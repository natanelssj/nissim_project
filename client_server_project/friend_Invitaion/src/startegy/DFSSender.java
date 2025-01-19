package startegy;

import dao.PersonDAO;
import dm.Person;
import main.java.AlgorithmSearch;

import java.util.*;

public class DFSSender implements ISendStrategy {
    private final PersonDAO personDao;
    private final AlgorithmSearch dfs;

    public DFSSender(PersonDAO personDao, AlgorithmSearch dfs) {
        this.personDao = personDao;
        this.dfs = dfs;
    }

    @Override
    public String send() {
        return "";
    }

    @Override
    public List<Person> sendInvitations(int startUserId, int range) {
        // רשימה לשמירת האנשים שביקרנו בהם
        List<Person> invitedPersons = new ArrayList<>();

        // גרף החיבורים
        Map<Integer, List<Integer>> graph = personDao.getConnectionsGraph();

        // מחסנית והסט לשמירת המבקרים
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();

        // התחל את החיפוש מ-id של המשתמש ההתחלתי
        stack.push(startUserId);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited.contains(current)) {
                visited.add(current);

                // הוסף את האדם לרשימה
                Person person = personDao.find(current);
                if (person != null) {
                    invitedPersons.add(person);
                }

                // הוסף שכנים למחסנית
                List<Integer> neighbors = graph.getOrDefault(current, new ArrayList<>());
                for (int neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        stack.push(neighbor);
                    }
                }
            }
        }

        return invitedPersons;
    }
}
