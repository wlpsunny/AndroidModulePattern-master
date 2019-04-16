package productconsume;

import java.util.LinkedList;

public class CompanyStorage {
    private final int MAX_SIZE = 50;
    private LinkedList<Object> products = new LinkedList<Object>();

    //生产产品
    public void produce(Object src) {
        synchronized (products) {
            while (products.size() == MAX_SIZE) {
                System.out.println("仓库已满，暂时不能继续生产!");
                try {
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            products.addFirst(src);
            System.out.println("已生产成功，当前仓库存货量："+products.size());
            products.notifyAll();
        }
    }

    // 消费产品
    public Object consume() {
        synchronized (products) {
            while (products.isEmpty()) {
                System.out.println("仓库已空，暂时不能继续消费!");
                try {
                    products.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object object = products.removeLast();
            System.out.println("已消费成功，当前仓库存货量："+products.size());
            products.notifyAll();
            return object;
        }
    }
}
