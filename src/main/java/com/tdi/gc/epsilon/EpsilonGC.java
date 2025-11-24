package com.tdi.gc.epsilon;

public class EpsilonGC {

    //-XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -Xms64m -Xmx64m -Xlog:gc*::time -Xlog:gc=debug:file=gc.text
    public static void main(String[] args) {
        System.out.println("Start the program");
        System.out.println("Start the loop");

        for (int i = 200; i < 200_000_000; i++) {
            String string = String.valueOf(i);
        }

        System.out.println("End the loop");
    }
}
