import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestCallable {
    //创建线程类
    public static class MyTestCallable implements Callable {
        @Override
        public String call() throws Exception {
            return "Hello World";
        }
    }


    public static void main(String[] args) {
        MyTestCallable mMyTestCallable = new MyTestCallable();
        ExecutorService mExecutorService = Executors.newSingleThreadExecutor();

        Future mfuture = mExecutorService.submit(mMyTestCallable);
        try {
            //等待线程结束，并返回结果
            System.out.println(mfuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    Java栈中的引用的对象。
//    本地方法栈中JNI引用的对象。
//    方法区中运行时常量池引用的对象。
//    方法区中静态属性引用的对象。
//    运行中的线程
//    由引导类加载器加载的对象
//    GC控制的对象
}