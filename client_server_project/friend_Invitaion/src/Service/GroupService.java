package Service;

import dao.GroupDao;
import dm.Group;

import java.util.List;

public class GroupService {
    private final GroupDao groupDao;

    public GroupService(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    public List<Group> getAllGroups() {
        return groupDao.findAll();
    }
}
