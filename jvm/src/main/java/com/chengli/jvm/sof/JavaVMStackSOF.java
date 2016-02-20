package com.chengli.jvm.sof;

/**
 * Vm args : -Xss128k
 *
 * 虚拟机栈和本地方法栈溢出
 * 异常：
 *  java.lang.StackOverflowError
 * Created by chengli on 2016/2/20.
 */
public class JavaVMStackSOF {

    private static int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + stackLength);
            throw e;
        }
    }
}
