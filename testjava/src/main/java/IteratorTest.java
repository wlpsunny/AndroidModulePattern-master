import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by  wlp on 2018/5/22.
 */

public class IteratorTest {

    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList();
        arrayList.add(11);

        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer next = (Integer) iterator.next();
            if (next == 11) {
                iterator.remove();
            }
        }

    }
}
