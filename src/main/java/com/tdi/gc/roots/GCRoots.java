package com.tdi.gc.roots;

import java.util.Scanner;

public class GCRoots {

    public static void main(String[] args) {
        System.out.println("Start the program!");
        var a = new A();
        var b1 = new B(a);
        var b2 = new B(new A());

        new Scanner(System.in).nextLine();
        System.out.println("Set null");

        a = null;
        b2 = null;

        new Scanner(System.in).nextLine();
        System.out.println("End the program!");
    }
}
