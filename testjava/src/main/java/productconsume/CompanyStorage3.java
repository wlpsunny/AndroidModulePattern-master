package productconsume;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CompanyStorage3 {
    private final int MAX_SIZE = 50;

    private LinkedList<Object> products = new LinkedList<Object>();
    private final Lock lock = new ReentrantLock();
    private final Condition full = lock.newCondition();
    private final Condition empty = lock.newCondition();

    //生产产品
    public void produce(Object src) {
        try {
            lock.lock();
            while (products.size() == MAX_SIZE) {
                System.out.println("仓库已满，暂时不能继续生产!");
                try {
                    full.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            products.addFirst(src);

            System.out.println("已生产成功，当前仓库存货量："+products.size());
            empty.signalAll();
        } finally {
            lock.unlock();
        }
    }

    //消费产品
    public Object consume() {
        try {
            lock.lock();
            while (products.isEmpty()) {
                System.out.println("仓库已空，暂时不能继续消费!");
                try {
                    empty.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object object = products.remove();
            System.out.println("已消费成功，当前仓库存货量："+products.size());
            full.signalAll();
            return object;
        } finally {
            lock.unlock();
        }
    }
}
