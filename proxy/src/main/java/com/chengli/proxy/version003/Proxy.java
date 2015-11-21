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
                    "           handler.invoke();\n" +
                    "           }catch(Exception e){\n" +
                    "           }\n" +
                    "    }\n";
        }

        /*动态编译这段代码*/
        String src = "package com.chengli.proxy.base;\n" +
                "\n" + "import com.chengli.proxy.version003.InvocationHandler;\n\n" +
                "public class TankTimeProxy implements " + inter.getName() + " {\n" +
                "    private InvocationHandler handler;\n" +
                "\n" +
                "    public TankTimeProxy(InvocationHandler handler) {\n" +
                "        this.handler = handler;\n" +
                "    }\n" +
                "\n" +
                methodStr +
                "}";
        Class clazz = Complier.complie(src, "H:/com/chengli/proxy/base/TankTimeProxy.java");
        Constructor constructor = clazz.getConstructor(InvocationHandler.class);
        return constructor.newInstance(handler);
    }
}
