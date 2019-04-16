package com.guiying.module.girls.main;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.guiying.module.common.Constant;
import com.guiying.module.common.base.BaseActionBarActivity;
import com.guiying.module.common.data.Test;
import com.guiying.module.common.utils.ToastUtils;
import com.guiying.module.girls.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;


@Route(path = Constant.GirlsActivity)
public class GirlsActivity extends BaseActionBarActivity {

    private GirlsView mView;
    private GirlsContract.Presenter mPresenter;

    @Override
    protected int setTitleId() {
        return R.string.girls_activity_title;
    }

    @Autowired()
    String stringtest;

    @Autowired(name = "stu")
    Test stu;

    @Subscribe
    public void handleEvent(String event) {
        // do something
        ToastUtils.showLongToast(event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);

        EventBus.getDefault().register(this);
        mView = new GirlsView(this);
        setContentView(mView);
        mPresenter = new GirlsPresenter(mView);
        mPresenter.start();

//        Log.d("===========", stringtest);

//        ToastUtils.showLongToast(stringtest + stu.toString());
    }


}
