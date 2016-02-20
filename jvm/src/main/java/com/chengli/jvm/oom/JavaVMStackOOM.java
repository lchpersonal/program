package com.chengli.jvm.oom;

/**
 * 虚拟机栈和本地方法栈溢出
 * <p>
 * Vm args: -Xss20m
 * <p>
 * 不要执行此方法，会死机。
 * 不要执行此方法，会死机。
 * 不要执行此方法，会死机。
 * 跑死机了了也没实验出来
 * <p>
 * <pre>
 * 异常：
 *     java.lang.OutOfMemoryError: unable to create new native thread
 * </pre>
 * <p>
 * Created by chengli on 2016/2/20.
 */
public class JavaVMStackOOM {

    private void dontStop() {
        while (true) {

        }
    }

    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM javaVMStackOOM = new JavaVMStackOOM();
        javaVMStackOOM.stackLeakByThread();
    }
}
