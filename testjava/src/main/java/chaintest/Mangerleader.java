package chaintest;

/**
 * Created by  wlp on 2018/6/6.
 */

public class Mangerleader extends Leader {
    @Override
    public int limit() {
        return 5000;
    }

    @Override
    public void handle(int money) {
        System.out.println("总经理批复报销" + money + "元");

    }

    @Override
    public String getleader() {
        return "我是总经理";
    }
}
