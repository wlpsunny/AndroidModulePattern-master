package volatileTest;

/**
 * Created by  wlp on 2018/5/4.
 */

public class SingleTest {

    private SingleTest() {

    }

    public static SingleTest getSingleTon() {
        return SingleTonHolder.singleTest;
    }

    private static class SingleTonHolder {

        private static SingleTest singleTest = new SingleTest();


    }
}
