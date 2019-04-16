package com.guiying.module.news;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.guiying.module.common.Constant;

/**
 * Created by Administrator on 2019/3/27.
 */

@Interceptor(priority = 10)
public class UsesecondInterceptor implements IInterceptor {
    /**
     * The operation of this interceptor.
     *
     * @param postcard meta
     * @param callback cb
     */
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.d("====", "UsesecondInterceptor   process        " + Thread.currentThread().getName());
        if (postcard.getPath().equals(Constant.NewsDetailActivity)) {
            Log.d("====", "UsesecondInterceptor   process        进行拦截NewsDetailActivity");
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
        Log.d("====", "UsesecondInterceptor   init");

    }
}
