package abstractfactory;

/**
 * Created by  wlp on 2018/5/22.
 */

public class HpFactory extends ComputerFactory {
    @Override
    public DesktopComputer createDesktopComputer() {
        return new HpDesktopComputer();
    }

    @Override
    public NetbookComputer createNetbookComputer() {
        return new HpNetbookComputer();
    }
}
