package com.guiying.module.common.iterface;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface HelloService extends IProvider {
    String sayHello(String name);
}