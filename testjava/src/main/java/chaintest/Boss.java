package chaintest;

/**
 * Created by  wlp on 2018/6/6.
 */

public class Boss extends Leader {
    @Override
    public int limit() {
        return Integer.MAX_VALUE;
    }

    @Override
    public void handle(int money) {

        System.out.println("boss批复报销" + money + "元");
    }

    @Override
    public String getleader() {
        return "我是boss";
    }
}
