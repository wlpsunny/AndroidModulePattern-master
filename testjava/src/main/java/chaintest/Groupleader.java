package chaintest;

/**
 * Created by  wlp on 2018/6/6.
 */

public class Groupleader extends Leader {
    @Override
    public int limit() {
        return 500;
    }

    @Override
    public void handle(int money) {
        System.out.println("组长批复报销" + money + "元");
    }

    @Override
    public String getleader() {
        return "我是组长";
    }
}
