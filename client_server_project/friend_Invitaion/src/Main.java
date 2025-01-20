

import Service.InvitationService;
import dao.PersonDAO;
import dm.Person;
import main.java.AlgorithmSearch;
import main.java.BFS;
import main.java.DFS;
import server.Server;
import startegy.BFSSender;
import startegy.DFSSender;

public class Main {
    public static void main(String[] args) {
         PersonDAO personDao = new PersonDAO();
        personDao.addConnection(1, 2);
        personDao.addConnection(1, 3);
        personDao.addConnection(2, 4);
        personDao.addConnection(3, 5);
        AlgorithmSearch algorithmSearch;
        personDao.save(new Person(1, "Alice"));
        personDao.save(new Person(2, "Bob"));
        personDao.save(new Person(3, "Charlie"));
        personDao.save(new Person(4, "David"));
        personDao.save(new Person(5, "Eve"));

        InvitationService invitationService = new InvitationService();

        // BFS
        invitationService.setStrategy(new BFSSender(personDao, new BFS()));
        System.out.println("BFS: " + invitationService.sendInvitations(1, 2));

        // DFS
        invitationService.setStrategy(new DFSSender(personDao, new DFS()));
        System.out.println("DFS: " + invitationService.sendInvitations(1, 2));



        Server server=new Server();
        server.tryserver();
    }
}
