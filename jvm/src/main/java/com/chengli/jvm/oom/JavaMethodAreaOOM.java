package com.chengli.jvm.oom;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 方法区溢出
 * 实验方法：借助CGLIB运行时动态生成代理类对象
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * <p>
 * <pre>
 * 异常：
 *      java.lang.OutOfMemoryError: PermGen space
 * </pre>
 * Created by chengli on 2016/2/20.
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
        }
    }

    static class OOMObject {

    }
}
