package chaintest;

/**
 * Created by  wlp on 2018/6/6.
 */

public abstract class Leader {
    protected Leader nextLeader;

    public abstract int limit();

    public abstract void handle(int money);

    public abstract String getleader();


    public void handleRequest(int money) {
        System.out.println(getleader());
        if (money <= limit()) {
            handle(money);
        } else {
            System.out.println("报账额度不足，提交领导");
            if (nextLeader != null) {
                nextLeader.handleRequest(money);
            }
        }

    }

}
