package com.guiying.module.news;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.guiying.module.common.Constant;

import static android.R.attr.process;

/**
 * Created by Administrator on 2019/3/27.
 */

@Interceptor(priority = 1)
public class UseInterceptor implements IInterceptor {
    /**
     * The operation of this interceptor.
     *
     * @param postcard meta
     * @param callback cb
     */
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.d("====", "UseInterceptor   process        " + Thread.currentThread().getName());

        Log.d("=========", "===" + postcard.toString());
        if (postcard.getPath().equals(Constant.NewsDetailActivity)) {
            Log.d("====", "UseInterceptor   process        进行拦截NewsDetailActivity");
        }
        callback.onContinue(postcard);
    }

    /**
     * Do your init work in this method, it well be call when processor has been load.
     *
     * @param context ctx
     */
    @Override
    public void init(Context context) {
        Log.d("====", "UseInterceptor   init");

    }
}
