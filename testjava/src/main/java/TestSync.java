public class TestSync {
    public static void main(String[] args) {

        for (int i = 0; i < 1000; i++) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    Count count = new Count();
                    //同步静态方法时，结果总是1000
                     Count.addCountS();
                    //而同步非静态方法时，结果却不一定，这是因为这里同步的是非静态方法，持有锁的是调用该方法的对象，而这个run方法每次会new一个count实例，所以每次是不同的锁。
//                    count.addCount();


                    System.out.println(count);

                }

            }).start();

        }

    }
}
