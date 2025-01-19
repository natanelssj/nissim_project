package dm;

import java.util.List;

public class Group {
    private final int id;
    private final String name;
    private final List<Person> members;

    public Group(int id, String name, List<Person> members) {
        this.id = id;
        this.name = name;
        this.members = members;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Person> getMembers() {
        return members;
    }
}
