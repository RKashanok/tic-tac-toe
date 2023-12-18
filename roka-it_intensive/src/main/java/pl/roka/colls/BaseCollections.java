package pl.roka.colls;

import java.util.*;

public class BaseCollections {
    public static void main(String[] args) {

        // List, Set, Queue
        List <String> kolja = new ArrayList<>();
        List <String> arnold = new LinkedList<>();

        for (int i = 0; i < 50; i++) {
            kolja.add("Ballon" + i);
        }

        for (int i = 0; i < 50; i++) {
            arnold.add("Ballon" + i);
        }

        for (int i = 0; i < 50; i++) {
            kolja.add("Ballon" + i);
        }

        for (int i = 0; i < 50; i++) {
            arnold.add("Ballon" + i);
        }

        System.out.println(kolja);
        System.out.println(arnold);

        Set<String> vasilij = new HashSet<>();
        vasilij.addAll(kolja);
        System.out.println(vasilij);
    }
}
