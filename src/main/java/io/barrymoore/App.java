// Copyright Barry Moore 2018. All rights reserved
package io.barrymoore;

import com.google.common.base.Preconditions;


/**
 * Accept a range and print out all prime numbers
 */
public class App {
    public static void main(String[] args) {
        PrimeNumberGeneratorImpl pm = new PrimeNumberGeneratorImpl();
        try {
            App.validateArguments(args);
            pm.generate(Integer.valueOf(args[0]), Integer.valueOf(args[1]))
                    .forEach(p -> System.out.println(p));

        } catch (IllegalArgumentException e) {
            printHelp();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void validateArguments(String[] args) {
        Preconditions.checkArgument(args.length == 2, "2 arguments are required");
        Preconditions.checkArgument(args[0].matches("/[0-9]*/"), "Both parameters must be integers");
        Preconditions.checkArgument(args[1].matches("/[0-9]*/"), "Both parameters must be integers");
    }

    private static void printHelp() {
        System.out.println("Usage:  java App <startRangeInt> <endRangeInt>");
    }
}
