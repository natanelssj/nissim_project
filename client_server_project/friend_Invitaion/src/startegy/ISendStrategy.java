package startegy;

import dm.Person;

import java.util.List;

public interface ISendStrategy {
    public String send();

    List<Person> sendInvitations(int startUserId, int range);
}
