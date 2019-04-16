import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by  wlp on 2019/1/14.
 */
public class RetranReadWriteLockTest {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final RetranReadWriteLockTest test = new RetranReadWriteLockTest();

        new Thread() {
            public void run() {
                test.get(Thread.currentThread());
            }

            ;
        }.start();

        new Thread() {
            public void run() {
                test.get(Thread.currentThread());
            }

            ;
        }.start();

    }

    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();

            while (System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName() + "正在进行读操作");
            }
            System.out.println(thread.getName() + "读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }
}
