package pl.roka.operators;

import java.util.Random;

public class Logical {

    static Random rand = new Random();

    public static void main(String[] args) throws InterruptedException {
        // Logical operators &, |, &&, ||, !

        if(test1() || test2() || test3()) {
            System.out.println("Welcome friend!");
        } else {
            System.out.println("Get out of here!!!");
        }
    }

    public static boolean test1() throws InterruptedException {
        Thread.sleep(1000 + rand.nextInt(5000));
        boolean res = rand.nextBoolean();
        System.out.println("test1: " + res);
        return res;
    }

    public static boolean test2() throws InterruptedException {
        Thread.sleep(1000 + rand.nextInt(5000));
        boolean res = rand.nextBoolean();
        System.out.println("test2: " + res);
        return res;
    }

    public static boolean test3() throws InterruptedException {
        Thread.sleep(1000 + rand.nextInt(5000));
        boolean res = rand.nextBoolean();
        System.out.println("test3: " + res);
        return res;
    }
}
