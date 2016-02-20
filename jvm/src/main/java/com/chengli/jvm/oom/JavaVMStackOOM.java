package com.chengli.jvm.oom;

/**
 * Vm args: -Xss20m
 * <p>
 * 不要执行此方法，会死机。
 * 不要执行此方法，会死机。
 * 不要执行此方法，会死机。
 * <p>
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
