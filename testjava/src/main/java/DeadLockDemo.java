public class DeadLockDemo {

    public static void main(String[] args) {
        // 线程a
        Thread td1 = new Thread(new Runnable() {
            public void run() {
                DeadLockDemo.method1();
            }
        });
        // 线程b
        Thread td2 = new Thread(new Runnable() {
            public void run() {
                DeadLockDemo.method2();
            }
        });

        td1.start();
        td2.start();

        String text = "03:06";
        String[] split = text.split(":");

        long s = Integer.parseInt(split[0]) * 60 ;
        long time = Integer.parseInt(split[1]);

        System.out.println(s + time);
    }

    public static void method1() {
        synchronized (String.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程a尝试获取integer.class");
            synchronized (Integer.class) {
                System.out.println("Integer.class");
            }
        }
    }

    public static void method2() {
        synchronized (Integer.class) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程b尝试获取String.class");
            synchronized (String.class) {
                System.out.println("String.class");
            }
        }
    }
}