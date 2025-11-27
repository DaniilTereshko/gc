package com.tdi.gc.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;

public class Phantom {

    public static void main(String[] args) throws InterruptedException {
        example1();
    }

    private static void example1() throws InterruptedException {
        var obj = new Object();
        ReferenceQueue<Object> objectReferenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(obj, objectReferenceQueue);

        System.out.println("[Before GC] Phantom reference value: " + phantomReference.get());
        System.out.println("[Before GC] Phantom reference in reference queue? " + objectReferenceQueue.poll());

        obj = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);

        System.out.println("[After GC] Phantom reference value: " + phantomReference.get());
        System.out.println("[After GC] Phantom reference in reference queue? " + objectReferenceQueue.poll());
    }
}
