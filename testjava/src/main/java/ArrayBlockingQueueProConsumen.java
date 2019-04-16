import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueProConsumen {
    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
//        ArrayBlockingQueueProConsumen test = new ArrayBlockingQueueProConsumen();
//        Producer producer = test.new Producer();
//        Consumer consumer = test.new Consumer();
//        producer.start();
//        consumer.start();

        final CompanyStorage c = new CompanyStorage();
        for (int i = 0; i < 10; i++) {

            new Thread(new Runnable() {
                @Override
                public void run() {

                    c.product(new Object());
                }
            }).start();
        }
        for (int i = 0; i < 6; i++) {


            new Thread(new Runnable() {
                @Override
                public void run() {

                    c.consume();
                }
            }).start();
        }
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}