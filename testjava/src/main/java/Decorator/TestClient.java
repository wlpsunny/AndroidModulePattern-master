package Decorator;

/**
 * Created by  wlp on 2018/9/21.
 */

public class TestClient {

    public static void main(String[] args) {

        YangGguo yangGguo = new YangGguo();

        OuYnagfeng ouYnagfeng = new OuYnagfeng(yangGguo);
        ouYnagfeng.attackMagic();



        Hongqigong hongqigong = new Hongqigong(yangGguo);


        hongqigong.attackMagic();


    }
}
