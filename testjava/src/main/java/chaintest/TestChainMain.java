package chaintest;

/**
 * Created by  wlp on 2018/5/22.
 */

public class TestChainMain {
    public static void main(String[] args) {
        Leader groupleader = new Groupleader();
        Leader director = new Director();
        Leader mangerleader = new Mangerleader();
        Leader boss = new Boss();

        groupleader.nextLeader = director;
        director.nextLeader = mangerleader;
        mangerleader.nextLeader = boss;


        groupleader.handleRequest(80000);
    }

}
