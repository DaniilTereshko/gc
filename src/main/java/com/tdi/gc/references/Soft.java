package com.tdi.gc.references;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Soft {

    public static void main(String[] args) throws InterruptedException {
        //example1();
        example2();
    }

    private static void example1() throws InterruptedException {
        var obj = new Object();
        SoftReference<Object> softReference = new SoftReference<>(obj);
        obj = null;
        System.gc();
        TimeUnit.SECONDS.sleep(3);

        System.out.println("SoftReference value: " + softReference.get());
    }

    private static void example2() throws InterruptedException {
        List<SoftReference<Object>> softReferences = new ArrayList<>();
        for (int i = 0; i < 5_000_000; i++) {
            softReferences.add(new SoftReference<>(String.valueOf(i)));
        }
        new Scanner(System.in).nextLine();

        System.gc();

        int liveObjectsAfterGc = 0;
        for (var ref : softReferences) {
            if (ref.get() != null) {
                liveObjectsAfterGc++;
            }
        }
        System.out.println("LiveObjectsAfterGc: " + liveObjectsAfterGc);
    }
}
