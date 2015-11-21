package com.chengli.proxy.version003;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by chengli on 2015/11/21.
 */
public interface InvocationHandler {

    void invoke() throws InvocationTargetException, IllegalAccessException;
}
