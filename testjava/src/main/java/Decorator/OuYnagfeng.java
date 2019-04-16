package Decorator;

/**
 * Created by  wlp on 2018/9/21.
 */

public class OuYnagfeng extends Master {
    public OuYnagfeng(SwordMan mSwordsman) {
        super(mSwordsman);
    }

    @Override
    public void attackMagic() {

        super.attackMagic();

        teachAttackMagic();

    }

    public void teachAttackMagic() {
        System.out.println("欧阳锋教授蛤蟆功");
        System.out.println("杨过使用蛤蟆功");

    }

}
