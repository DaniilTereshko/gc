package com.tdi.gc.references;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Weak {

    public static void main(String[] args) throws InterruptedException {
        //example1();
        example2();
    }

    private static void example1() throws InterruptedException {
        var obj = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(obj);
        obj = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);

        System.out.println("WeakReference value: " + weakReference.get());
    }

    private static void example2() throws InterruptedException {
        List<WeakReference<Object>> weakReferences = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            weakReferences.add(new WeakReference<>(new Object()));
        }
        int liveObjectsBeforeGc = 0;

        for (var ref : weakReferences) {
            if (ref.get() != null) {
                liveObjectsBeforeGc++;
            }
        }
        System.out.println("LiveObjectsBeforeGc: " + liveObjectsBeforeGc);
        System.gc();

        int liveObjectsAfterGc = 0;
        for (var ref : weakReferences) {
            if (ref.get() != null) {
                liveObjectsAfterGc++;
            }
        }
        System.out.println("LiveObjectsAfterGc: " + liveObjectsAfterGc);
    }
}
