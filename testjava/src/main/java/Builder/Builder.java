package Builder;

/**
 * Created by  wlp on 2018/5/22.
 * 定义组装的过程
 */

public abstract class Builder {

    public abstract void buidcpu(String cpu);

    public abstract void buidamr(String amr);

    public abstract void buidsd(String sd);

    //获取电脑
    public abstract Computer create();
}
