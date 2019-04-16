package abstractfactory;

/**
 * Created by  wlp on 2018/5/22.
 */

public abstract class ComputerFactory {

    public ComputerFactory() {

    }

    public abstract DesktopComputer createDesktopComputer();

    public abstract NetbookComputer createNetbookComputer();

}
