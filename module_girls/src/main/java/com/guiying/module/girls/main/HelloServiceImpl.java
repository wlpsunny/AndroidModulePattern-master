package com.guiying.module.girls.main;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.guiying.module.common.iterface.HelloService;

// 实现接口
@Route(path = "/girls/hello", name = "测试服务")
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        return "hello, " + name;
    }

    @Override
    public void init(Context context) {

    }
}