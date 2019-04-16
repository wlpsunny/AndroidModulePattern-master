package publishsubscribe;

/**
 * Created by  wlp on 2018/5/18.
 *
 * 使用场景
 关联行为场景，需要注意的是，关联行为是可拆分的，而不是“组合”关系。
 事件多级触发场景。
 跨系统的消息交换场景，如消息队列、事件总线的处理机制。
 优点
 解除耦合，让耦合的双方都依赖于抽象，从而使得各自的变换都不会影响另一边的变换。

 缺点
 在应用观察者模式时需要考虑一下开发效率和运行效率的问题，程序中包括一个被观察者、多个观察者，开发、调试等内容会比较复杂，
 而且在Java中消息的通知一般是顺序执行，那么一个观察者卡顿，会影响整体的执行效率，在这种情况下，一般会采用异步实现
 */

public class Client {

    public static void main(String[] args) {
        SubscriptionSubject subscriptionSubject = new SubscriptionSubject();
        WeixinUser sw = new WeixinUser("ssswww");
        WeixinUser gdd = new WeixinUser("gdd");
        WeixinUser wlp = new WeixinUser("wlp");


        subscriptionSubject.addObserver(sw);
        subscriptionSubject.addObserver(gdd);
        subscriptionSubject.addObserver(wlp);

        subscriptionSubject.sendmessage("你你你");
    }
}
