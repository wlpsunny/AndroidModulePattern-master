import java.util.concurrent.atomic.AtomicInteger;

public class TestAsynTreadXunlei {
    public static void main(String argv[]) {
        AtomicInteger synObj = new AtomicInteger(0);
        Runnable r = new PrintThread(synObj);
        try {
            Thread a = new Thread(r, "A");
            Thread b = new Thread(r, "B");
            Thread c = new Thread(r, "C");
            a.start();
            b.start();
            c.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class PrintThread implements Runnable {
    private AtomicInteger synObj;

    public PrintThread(AtomicInteger synObj) {
        this.synObj = synObj;
    }

    @Override
    public void run() {
        print();
    }

    public void print() {
        for (int i = 0; i < 10; i++) {
            try {
                synchronized (synObj) {
                    if (synObj.get() % 3 == 0) {
                        System.out.println("A");
                        synObj.set(synObj.get() + 1);
                    } else if (synObj.get() % 3 == 1) {
                        System.out.println("B");
                        synObj.set(synObj.get() + 1);
                    } else if (synObj.get() % 3 == 2) {
                        System.out.println("C");
                        synObj.set(synObj.get() + 1);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

