package pl.roka.cycles;

import java.util.Scanner;

public class BasicCycles {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            System.out.println("i = " + i);

            for (int j = 0; j < 3; j++) {
                System.out.println("j = " + j);

                for (int k = 0; k < 3; k++) {
                    System.out.println("k = " + k);
                }
            }
        }

        int iterationsCount = 0;
        while (iterationsCount < 20) {
            System.out.println("Hello");
            iterationsCount ++;
        }

    }
}
