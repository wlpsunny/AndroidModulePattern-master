package Builder;

/**
 * Created by  wlp on 2018/5/22.
 *
 * 装机人员
 */

public class WlpComputerBuilder extends Builder {

    private Computer computer = new Computer();

    @Override
    public void buidcpu(String cpu) {
        computer.setCpu(cpu);


    }

    @Override
    public void buidamr(String amr) {
        computer.setAmr(amr);
    }

    @Override
    public void buidsd(String sd) {
        computer.setSd(sd);
    }

    @Override
    public Computer create() {
        return computer;
    }
}
