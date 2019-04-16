import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CompanyStorage {
    private final int MAX_SIZE = 50;
    private BlockingQueue<Object> products = new LinkedBlockingQueue<Object>();




    //生产商品
    public synchronized boolean product(Object src) {
        if (products.size() == MAX_SIZE) {
            System.out.println("仓库已满，暂时不能继续生产!");
            return false;
        }

        try {
            products.put(src);
            System.out.println("已生产成功，当前仓库存货量：" + products.size());
            return true;
        } catch (InterruptedException e) {
            System.out.println("生产失败，" + e.getMessage());
        }
        return false;
    }



    //消费商品
    public synchronized Object consume() {
        if (products.isEmpty()) {
            System.out.println("仓库已空，暂时不能继续消费!");
            return null;
        }

        try {
            Object object = products.take();
            System.out.println("已消费成功，当前仓库存货量：" + products.size());
            return object;
        } catch (InterruptedException e) {
            System.out.println("消费失败，" + e.getMessage());
        }
        return null;
    }
}