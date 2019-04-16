package abstractfactory;

/**
 * Created by  wlp on 2018/5/22.
 */

public class LenovoFactory extends ComputerFactory {
    @Override
    public DesktopComputer createDesktopComputer() {
        return new LenovoDesktopComputer();
    }

    @Override
    public NetbookComputer createNetbookComputer() {
        return new LenovoNetbookComputer();
    }
}
