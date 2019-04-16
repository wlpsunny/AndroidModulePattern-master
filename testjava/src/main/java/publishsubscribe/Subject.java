package publishsubscribe;

/**
 * Created by  wlp on 2018/5/18.
 */

public interface Subject {

    public void addObserver(Observer observer);

    public void deleteObserver(Observer observer);

    public void sendmessage(String msg);
}
