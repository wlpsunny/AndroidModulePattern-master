package TestProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HouseAgentInvocationHandler implements InvocationHandler {
    private Object object;

    public HouseAgentInvocationHandler(Object object) {
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Integer money=(Integer) args[0];
        System.out.println("我是中介，业主的房子我实际卖了"+money+"块钱");
        Object result=method.invoke(object, args);
        System.out.println("我是中介，这次交易我赚了不少钱！！！");

        System.out.println("proxy.getClass()="+proxy.getClass());
        System.out.println("method.getName()="+method.getName());
        for(Object object:args) {
            System.out.println("object.getClass()="+object.getClass());
        }
        return result;
    }
}