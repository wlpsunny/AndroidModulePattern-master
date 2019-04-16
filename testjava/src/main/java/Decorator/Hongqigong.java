package Decorator;

/**
 * Created by  wlp on 2018/9/21.
 */

public class Hongqigong extends Master {
    public Hongqigong(SwordMan mSwordsman) {
        super(mSwordsman);
    }

    @Override
    public void attackMagic() {

        super.attackMagic();

        teachAttackMagic();

    }

    public void teachAttackMagic() {
        System.out.println("洪七公教授打狗棒法");
        System.out.println("杨过使用打狗棒法");

    }

}
