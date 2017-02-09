package com.cl.test.type;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by chengli on 2016/11/14.
 */
public class ByteTest {
    public static void main(String[] args) {
        Method[] methods = ByteTest.class.getMethods();
        for (Method method : methods) {
            if(method.getName().equals("test")){
                System.out.println(method.getGenericReturnType().getTypeName());
                System.out.println(method.getReturnType().getTypeName());
            }
        }
    }

    public List<ByteTest> test(){
        return null;
    }
}
