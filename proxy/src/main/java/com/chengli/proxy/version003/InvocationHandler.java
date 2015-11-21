package com.chengli.proxy.version003;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chengli on 2015/11/21.
 */
public interface InvocationHandler {

    void invoke(Method method, Object object) throws InvocationTargetException, IllegalAccessException;
}
