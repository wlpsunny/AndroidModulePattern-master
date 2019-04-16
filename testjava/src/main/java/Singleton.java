/**
 * Created by  wlp on 2018/6/6.
 */

public class Singleton {
    private void Singleton() {
    }

    public static Singleton getSingleton() {

        return SingleHolder.singleton;
    }

    private static class SingleHolder {

        private static Singleton singleton = new Singleton();
    }

}
