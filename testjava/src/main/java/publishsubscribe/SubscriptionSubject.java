package publishsubscribe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  wlp on 2018/5/18.
 */

public class SubscriptionSubject implements Subject {

    private List<Observer> list = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        list.add(observer);

    }

    @Override
    public void deleteObserver(Observer observer) {
        list.remove(observer);
    }

    @Override
    public void sendmessage(String msg) {
        for (Observer observer : list) {
            observer.update(msg);
        }

    }
}
