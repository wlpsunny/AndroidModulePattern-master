package abstractfactory;

/**
 * Created by  wlp on 2018/5/22.
 */

public class TestAbstractFactory {

    public static void main(String[] args) {

        ComputerFactory computerFactory = new LenovoFactory();


        computerFactory.createDesktopComputer().start();
        computerFactory.createNetbookComputer().start();


        ComputerFactory factory = new HpFactory();
        factory.createDesktopComputer().start();
        factory.createNetbookComputer().start();

    }
}
