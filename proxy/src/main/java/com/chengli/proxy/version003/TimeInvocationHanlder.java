package com.chengli.proxy.version003;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chengli on 2015/11/21.
 */
public class TimeInvocationHanlder implements InvocationHandler {

    private Method method;
    private Object object;

    public TimeInvocationHanlder(Method method, Object object) {
        this.method = method;
        this.object = object;
    }

    @Override
    public void invoke() throws InvocationTargetException, IllegalAccessException {
        System.out.println("start```哈哈");
        method.invoke(object, null);
        System.out.println("end ``` 嘎嘎");
    }
}
