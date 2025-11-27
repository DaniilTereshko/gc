package com.tdi.gc.references;

import java.lang.ref.PhantomReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class ReferenceQueue {

    public static void main(String[] args) throws InterruptedException {
        example3();
    }

    private static void example3() throws InterruptedException {
        var obj = new Object() {
        };

        java.lang.ref.ReferenceQueue<Object> queue = new java.lang.ref.ReferenceQueue<>();
        WeakReference<Object> weak = new WeakReference<>(obj, queue);
        PhantomReference<Object> phantom = new PhantomReference<>(obj, queue);
        obj = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("From weak link: " + weak.get());
        System.out.println("From phantom link: " + phantom.get());
        System.out.println("From queue: " + queue.poll());
        System.out.println("From queue: " + queue.poll());
    }
}
