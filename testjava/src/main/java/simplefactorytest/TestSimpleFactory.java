package simplefactorytest;

/**
 * Created by  wlp on 2018/5/22.
 * 简单工厂模式优缺点
 * 优点：
 * 使用户根据参数获得对应的类实例，避免了直接实例化类，降低了耦合性。
 * <p>
 * 缺点：
 * 可实例化的类型在编译期间已经被确定，如果增加新类型，则需要修改工厂，违背了开放封闭原则(ASD) 。 简单工厂需要知道所有要生成的类型，当子类过多或者子类层次过多时不适合使用。
 */

public class TestSimpleFactory {

    public static void main(String[] args) {

        ComputerFactory.createComputer("simplefactorytest.HpComputer").start();
    }
}
