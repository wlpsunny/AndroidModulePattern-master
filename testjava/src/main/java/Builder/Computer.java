package Builder;

/**
 * Created by  wlp on 2018/5/22.
 * 商品
 */

public class Computer {
    private String cpu;
    private String amr;
    private String sd;

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", amr='" + amr + '\'' +
                ", sd='" + sd + '\'' +
                '}';
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getAmr() {
        return amr;
    }

    public void setAmr(String amr) {
        this.amr = amr;
    }

    public String getSd() {
        return sd;
    }

    public void setSd(String sd) {
        this.sd = sd;
    }
}
