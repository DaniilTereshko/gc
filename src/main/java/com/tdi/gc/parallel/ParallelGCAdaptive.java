package com.tdi.gc.parallel;

import java.util.HashMap;
import java.util.Scanner;

public class ParallelGCAdaptive {

    //-XX:+UseParallelGC -Xms526m -Xmx526m -XX:+UseAdaptiveSizePolicy -Xlog:gc*::time
    public static void main(String[] args) {
        var container = new HashMap<String, String>();
        System.out.println("Start the program!");
        var prefix = "PRE-";

        new Scanner(System.in).nextLine();

        System.out.println("Start the loop one");
        for (int i = 0; i < 200_000; i++) {
            var string = prefix + i;
            container.put(string, string);
        }
        System.out.println("End the loop one");

        new Scanner(System.in).nextLine();

        System.out.println("Start the loop two");
        for (int i = 200_000; i < 400_000; i++) {
            var string = prefix + i;
            container.put(string, string);
        }
        System.out.println("End the loop two");

        new Scanner(System.in).nextLine();

        System.out.println("Start the loop three");
        for (int i = 400_000; i < 800_000; i++) {
            var string = prefix + i;
            container.put(string, string);
        }
        System.out.println("End the loop three");

        new Scanner(System.in).nextLine();

        System.out.println("Start the loop four");
        for (int i = 0; i < 800_000; i++) {
            var string = prefix + i;
            container.remove(string);
        }

        for (int i = 800_000; i < 4_500_000; i++) {
            var string = prefix + i;
            container.put(string, string);
        }
        System.out.println("End the loop four");

        new Scanner(System.in).nextLine();
        System.out.println("End of the program!");
    }
}
