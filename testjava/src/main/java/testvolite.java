/**
 * Created by  wlp on 2018/5/3.
 */

public class testvolite {
    public static void main(String[] args) {

        volatileKeyword();

    }

    private static volatile int start = 0;

    private static void volatileKeyword() {

        final Object a = new Object();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i < 10; i++) {
                        start++;
                        System.out.print("start = " + start);
                    }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            thread.start();
        }


    }
}
