import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Demon {
    public static void main(String[] args) {
//        Thread deamon = new Thread(new DaemonRunner(),"DaemonRunner");
//        //设置为守护线程
//        deamon.setDaemon(true);
//        deamon.start();//启动线程


        try {
            URL url = new URL("http://m.shouji.360tpcdn.com/160316/deab26b43b55089736817040f921c1e7/com.suning.mobile.ebuy_120.apk");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            // conn.setDoOutput(true);
            conn.setRequestMethod("HEAD");
            conn.setRequestProperty("Range", "bytes=" + 301 + "-" + 1000);
            Map<String, List<String>> headerMap = conn.getHeaderFields();
            Iterator<String> iterator = headerMap.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                List<String> values = headerMap.get(key);
                System.out.println(key + ":" + values.toString());
            }

            float ta = Float.parseFloat("20.11") +
                    Float.parseFloat("20.11") +
                    Float.parseFloat("20.11");

            System.out.println(ta + "");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }


    static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("这里的代码在java虚拟机退出时并不一定会执行哦！");
            }
        }
    }
}  