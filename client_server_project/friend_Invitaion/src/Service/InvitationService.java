package Service;

import dm.Person;
import Service.GroupService;
import startegy.ISendStrategy;

import java.util.List;

public class InvitationService {
    private ISendStrategy sendStrategy;

    public void setStrategy(ISendStrategy strategy) {
        this.sendStrategy = strategy;
    }

    public List<Person> sendInvitations(int startUserId, int range) {
        return sendStrategy.sendInvitations(startUserId, range);
    }
}
