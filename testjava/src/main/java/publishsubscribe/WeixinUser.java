package publishsubscribe;

/**
 * Created by  wlp on 2018/5/18.
 */

public class WeixinUser implements Observer {

    private String name;

    public WeixinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + "-" + message);

    }
}
