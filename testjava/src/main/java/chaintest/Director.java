package chaintest;

/**
 * Created by  wlp on 2018/6/6.
 */

public class Director extends Leader {
    @Override
    public int limit() {
        return 1000;
    }

    @Override
    public void handle(int money) {

        System.out.println("主管批复报销" + money + "元");
    }

    @Override
    public String getleader() {
        return "我是主管";
    }
}
