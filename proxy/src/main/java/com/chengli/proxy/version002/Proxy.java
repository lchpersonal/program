package com.chengli.proxy.version002;

import com.chengli.proxy.base.Complier;
import com.chengli.proxy.base.Moveable;

import java.lang.reflect.Constructor;

/**
 * 动态生成代理类
 * Created by chengli on 2015/11/21.
 */
public class Proxy {

    public static Object newProxyInstance(Object object) throws Exception {
        /*动态编译这段代码*/
        String src = "package com.chengli.proxy.version002;\n" +
                "\n" +
                "import com.chengli.proxy.base.Moveable;\n" +
                "\n" +
                "class TankTimeProxy implements Moveable {\n" +
                "    private Moveable moveable;\n" +
                "\n" +
                "    public TankTimeProxy(Moveable moveable) {\n" +
                "        this.moveable = moveable;\n" +
                "    }\n" +
                "\n" +
                "    @Override\n" +
                "    public void move() {\n" +
                "        System.out.println(\"beginTime:\" + System.currentTimeMillis());\n" +
                "        moveable.move();\n" +
                "        System.out.println(\"endTime:\" + System.currentTimeMillis());\n" +
                "    }\n" +
                "}";
        Class clazz = Complier.complie(src, "/proxy/src/main/java/com/chengli/proxy/version002/TankTimeProxy.java");
        Constructor constructor = clazz.getConstructor(Moveable.class);
        return constructor.newInstance(object);
    }
}
