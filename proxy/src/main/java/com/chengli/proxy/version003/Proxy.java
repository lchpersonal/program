package com.chengli.proxy.version003;

import com.chengli.proxy.base.Complier;
import com.chengli.proxy.base.Moveable;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 动态生成代理类
 * Created by chengli on 2015/11/21.
 */
public class Proxy {

    public static Object newProxyInstance(Object object, Class inter, InvocationHandler handler) throws Exception {
        Method[] methods = inter.getMethods();
        String methodStr = "";
        for (Method m : methods) {
            methodStr += "    @Override\n" +
                    "    public void " + m.getName() + "() {\n" +
                    "       try{\n" +
                    "           handler.invoke(method,object);\n" +
                    "           }catch(Exception e){\n" +
                    "           }\n" +
                    "    }\n";
        }

        /*动态编译这段代码*/
        String src = "package com.chengli.proxy.base;\n" +
                "\n" + "import com.chengli.proxy.version003.InvocationHandler;\n" +
                "\n" + "import java.lang.reflect.Method;\n\n" +
                "public class TankTimeProxy implements " + inter.getName() + " {\n" +
                "    private InvocationHandler handler;\n" +
                "    private Object object;\n" +
                "    private Method method;\n" +
                "\n" +
                "    public TankTimeProxy(Object object, Method method, InvocationHandler handler) {\n" +
                "        this.handler = handler;\n" +
                "        this.object = object;\n" +
                "        this.method = method;\n" +
                "    }\n" +
                "\n" +
                methodStr +
                "}";
        Class clazz = Complier.complie(src, "H:/com/chengli/proxy/base/TankTimeProxy.java");
        Constructor constructor = clazz.getConstructor(new Class[]{Object.class, Method.class, InvocationHandler.class,});
        return constructor.newInstance(object, inter.getMethods()[0], handler);
    }
}
