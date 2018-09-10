// Copyright Barry Moore 2018. All rights reserved
package io.barrymoore;

import io.barrymoore.predicates.PrimeTestPredicates;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;


/**
 * Accept a range and print out all prime numbers
 */
public class App {
    static Map<String, Function> functions = new HashMap();
    static {
        functions.put("-f1", PrimeTestPredicates.Function1);
        functions.put("-f2", PrimeTestPredicates.Function2);
        functions.put("-f3", PrimeTestPredicates.Function3);
    }

    public static void main(String[] args) {
        App app = new App();
        PrimeNumberGeneratorImpl pm = new PrimeNumberGeneratorImpl();

        try {
            List<String> params = new ArrayList();
            params.addAll(Arrays.asList(args));
            app.validateArguments(params);
            if (app.NamedFunction.test(params)) {
                String f = params.stream().filter(s -> s.startsWith("-f")).findFirst().orElse(null);
                if ( null != f) {
                    pm = new PrimeNumberGeneratorImpl(functions.get(f));
                    params.remove(f);
                }
            }
            int int1 = Integer.valueOf(params.get(0));
            int int2 = Integer.valueOf(params.get(1));
            pm.generate(Integer.valueOf(args[0]), Integer.valueOf(args[1]))
                    .forEach(p -> System.out.println(p));
            System.out.println("Done");

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
            printHelp();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void printHelp() {
        System.out.println("Usage:  java App -[f1, f2,f3] int int");
        System.out.println("Prints prime numbers for a given range from first int to second int");
        System.out.println("Options:");
        System.out.println("    -f1          : default. calculate prime numbers using function 1");
        System.out.println("    -f2          : calculate prime numbers using function 2");
        System.out.println("    -f3          : calculate prime numbers using function 3");
    }

    private void validateArguments(List args) {
        if (WrongNumberOfArgs.test(args) || InvalidParams.test(args))
            throw new IllegalArgumentException("Invalid arguments");
    }

    Predicate WrongNumberOfArgs = new Predicate<List<String>>() {
        @Override
        public boolean test(List<String> args) {
            return args.size() < 2 || args.size() > 4;
        }
    };

    Predicate InvalidParams = new Predicate<List<String>>() {
        @Override
        public boolean test(List<String> args) {
            long n = args.stream()
                    .filter(s -> s.matches("(([0-9][0-9]*)|(-[if][1-3]))"))
                    .map(s -> {
                        System.out.println(s);
                        return s;
                    })
                    .count();
            return n == 0;
        }
    };

    Predicate NamedFunction = new Predicate<List<String>>() {
        @Override
        public boolean test(List<String> args) {
            String str =  args.stream()
                 .filter(s -> s.startsWith("-f"))
                    .findFirst().orElse(null);
            return null != str;
        }
    };

}
