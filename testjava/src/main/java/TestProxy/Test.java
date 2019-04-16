package TestProxy;

/**
 * 静态代理，在代码运行前就已经存在了代理类的class编译文件
 */
public class Test {

    public static void main(String[] args) {
        Owner owner = new Owner();
        HouseAgent houseAgent = new HouseAgent(owner);
        houseAgent.sellHouse(10000 * 100);


    }

}