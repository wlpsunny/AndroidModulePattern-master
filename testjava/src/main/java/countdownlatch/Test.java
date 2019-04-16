package countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {


        //join的工作原理是，不停检查thread是否存活，如果存活则让当前线程永远wait，直到thread线程终止，线程的this.notifyAll 就会被调用。
//        Worker worker0 = new Worker("worker0", (long) (Math.random() * 2000 + 3000));
//        Worker worker1 = new Worker("worker1", (long) (Math.random() * 2000 + 3000));
//        Worker worker2 = new Worker("worker2", (long) (Math.random() * 2000 + 3000));
//
//        worker0.start();
//        worker1.start();
//
//        try {
//            worker0.join();
//            worker1.join();
//            System.out.println("准备工作就绪");
//
//            worker2.start();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        //CountDownLatch
        final CountDownLatch latch = new CountDownLatch(3);

        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();

        new Thread() {
            public void run() {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            ;
        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await(1000, TimeUnit.MILLISECONDS);
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}