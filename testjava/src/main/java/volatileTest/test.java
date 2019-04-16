package volatileTest;

/**
 * Created by  wlp on 2018/5/4.
 */

public class test {
    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final test test = new test();
        for (int i = 0; i < 5; i++) {
            new Thread() {
                public void run() {
                    for (int j = 0; j < 10; j++)
                        test.increase();
                }

            }.start();
        }
        //保证前面的线程都执行完
        while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(test.inc + "-------------");
    }

}
