package TestProxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理则是在代码运行时通过反射来动态的生成代理类的对象，并确定到底来代理谁。也就是我们在编码阶段不需要知道代理谁，代理谁我们将会在代码运行时决定。
 */
public class TestProxy02 {

    public static void main(String[] args) {
        TradeProtocol owner = new Owner();
        ClassLoader classLoader = owner.getClass().getClassLoader();
        Class<?>[] interfaces = owner.getClass().getInterfaces();
        //创建InvocationHandler
        HouseAgentInvocationHandler invocationHandler = new HouseAgentInvocationHandler(owner);
        //生成动态代理
        TradeProtocol tradeProtocol = (TradeProtocol) Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);

        tradeProtocol.sellHouse(1000000);


//        final MyClass myClass = new MyClass();
//        final MyClass myClass1 = new MyClass();
//        System.out.println(myClass.i);

    }


}

//class MyClass {
//    //    public int i = 0;
//    public final double i = Math.random();
//    public static double j = Math.random();
//}