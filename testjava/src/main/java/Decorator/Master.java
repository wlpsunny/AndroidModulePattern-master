package Decorator;

/**
 * Created by  wlp on 2018/9/21.
 */

public class Master extends SwordMan {
    private SwordMan swordMan;

    public Master(SwordMan mSwordsman) {
        this.swordMan = mSwordsman;
    }

    @Override
    public void attackMagic() {

        swordMan.attackMagic();
    }


}
