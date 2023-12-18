package pl.roka.operators;

import java.util.Random;
import java.util.Scanner;

public class IfElse {

    static Random rand = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter age plz:");
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("Hello adult");
            if (age >= 60) {
                System.out.println("Hello senior");
                if (age >= 75) {
                    System.out.println("Hello old");
                }
            }
        } else if (age >= 12) {
            System.out.println("Hello teenager");
        }

        System.out.println("program finished");
    }

    public static boolean test1() {
        return rand.nextBoolean();
    }
}
