package com.guiying.module.news.main;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.guiying.module.common.Constant;
import com.guiying.module.news.R;
import com.guiying.module.news.data.bean.Story;
import com.guiying.module.news.detail.NewsDetailActivity;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import org.greenrobot.eventbus.EventBus;


/**
 * <p>类说明</p>
 *
 * @author 张华洋 2017/4/20 22:26
 * @version V1.2.0
 * @name NewsListAdapter
 */
public class NewsListAdapter extends RecyclerArrayAdapter<Story> {

    private Context context;

    public NewsListAdapter(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new NewsListHolder(parent);
    }

    private class NewsListHolder extends BaseViewHolder<Story> {

        private TextView mTextView;
        private ImageView mImageView;

        NewsListHolder(ViewGroup parent) {
            super(parent, R.layout.item_news_list);
            mTextView = $(R.id.news_title);
            mImageView = $(R.id.news_image);
        }

        @Override
        public void setData(final Story data) {
            super.setData(data);
            mTextView.setText(data.getTitle());
            Glide.with(getContext())
                    .load(data.getImages()[0])
                    .centerCrop()
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(mImageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), NewsDetailActivity.class);
                    intent.putExtra("id", data.getId());
                    getContext().startActivity(intent);

//                    ARouter.getInstance().build(Constant.GirlsActivity).navigation();
//
//                    EventBus.getDefault().post("AAAAAAAAAAAA");
                    //跳转传值
//                    ARouter.getInstance().build(Constant.NewsDetailActivity)
//                            .withString("id", data.getId())
////                            .withParcelable("stu", new Test("Jack", 110))
//                            .navigation(context, new NavigationCallback() {
//                                @Override
//                                public void onFound(Postcard postcard) {
//                                    Log.d("====", "onFound");
//
//                                }
//
//                                @Override
//                                public void onLost(Postcard postcard) {
//                                    Log.d("====", "onLost");
//                                }
//
//                                @Override
//                                public void onArrival(Postcard postcard) {
//                                    Log.d("====", "onArrival");
//
//                                }
//
//                                @Override
//                                public void onInterrupt(Postcard postcard) {
//                                    Log.d("====", "onInterrupt");
//
//                                }
//                            });

                    //调用目标方法
//                    HelloService helloService = (HelloService) ARouter.getInstance().build("/girls/hello").navigation();
//
//                    String xxxx = helloService.sayHello("xxxx");
//                    ToastUtils.showLongToast(xxxx);

                    //fragment跳转
//                    Fragment fragment = (Fragment) ARouter.getInstance().build("/girls/girlsfragment")
//                            .navigation();

                }
            });
        }
    }
}
