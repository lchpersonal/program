package com.chengli.jvm.gc;

/**
 * Created by chengli on 2016/2/20.
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes , i am alive! :)");
    }

    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed~");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        //拯救自己成功
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no , i an dead! (:");
        }

        //完全一样的代码，拯救自己失败
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no , i an dead! (:");
        }
    }
}
