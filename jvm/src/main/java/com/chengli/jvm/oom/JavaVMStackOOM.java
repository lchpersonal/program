package com.chengli.jvm.oom;

/**
 * Vm args: -Xss20m
 * Created by chengli on 2016/2/20.
 */
public class JavaVMStackOOM {

    private void dontStop(){
        while (true){

        }
    }

    private void stackLeakByThread(){
        while (true){
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
