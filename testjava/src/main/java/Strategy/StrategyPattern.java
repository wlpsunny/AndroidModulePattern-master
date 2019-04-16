package Strategy;

/**
 *3. 优缺点
 在全面解析完后，我来分析下其优缺点：

 3.1 优点
 策略类之间可以自由切换
 由于策略类都实现同一个接口，所以使它们之间可以自由切换。
 易于扩展
 增加一个新的策略只需要添加一个具体的策略类即可，基本不需要改变原有的代码，符合“开闭原则“
 避免使用多重条件选择语句（if else），充分体现面向对象设计思想。
 3.2 缺点
 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
 策略模式将造成产生很多策略类，可以通过使用享元模式在一定程度上减少对象的数量。
 4. 应用场景
 一个系统需要动态地在几种算法中选择一种的情况
 如果在一个系统里面有许多类，它们之间的区别仅在于它们的行为，那么使用策略模式可以动态地让一个对象在许多行为中选择一种行为
 如果一个对象有很多的行为，如果不使用合适的模式，这些行为就只好使用多重的if-else语句来实现，此时，可以使用策略模式，把这些行为转移到相应的具体策略类里面，就可以避免使用难以维护的多重条件选择语句，并体现面向对象涉及的概念。
 不希望客户端知道复杂的、与算法相关的数据结构，在具体策略类中封装算法和相关的数据结构，提高算法的保密性与安全性。
 */

public class StrategyPattern {

    public static void main(String[] args) {

        SaleContext saleContext;

        System.out.print("春节来了\n");

        saleContext=new SaleContext("A");
        saleContext.salecontextshow();


        System.out.print("中秋来了\n");

        saleContext=new SaleContext("B");
        saleContext.salecontextshow();


    }
}
