package com.chengli.proxy.version003;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chengli on 2015/11/21.
 */
public class TimeInvocationHanlder implements InvocationHandler {

    @Override
    public void invoke(Method method, Object object) throws InvocationTargetException, IllegalAccessException {
        System.out.println("start```哈哈");
        method.invoke(object, null);
        System.out.println("end ``` 嘎嘎");
    }
}
