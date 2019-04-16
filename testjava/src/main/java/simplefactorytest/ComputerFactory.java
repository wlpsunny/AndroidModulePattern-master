package simplefactorytest;

/**
 * Created by  wlp on 2018/5/22.
 */

public class ComputerFactory {

    public static Computer createComputer(String type) {
        Computer computer=null;

        // 1. 根据 传入的产品类名 获取 产品类类型的Class对象

        // 2. 通过Class对象动态创建该产品类的实例
        try {
            Class product_Class = Class.forName(type);
            computer = (Computer) product_Class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//
//        switch (type){
//
//            case "lenovo":
//
//                computer=new LenovoComputer();
//                break;
//
//            case "hp":
//                computer=new HpComputer();
//                break;
//        }

        return computer;
    }
}
