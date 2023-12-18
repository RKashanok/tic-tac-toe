package pl.roka.operators;

public class ComparisonOperators {
    public static void main(String[] args) {

        // >, <, >=, <=, ==, !=
        boolean result = 5 > 3;
        boolean result2 = 5 < 3;
        boolean result3 = 5 <= 5;

        String s1 = "Hello";
        String s2 = "World";

        boolean strCompResult = s1.equals(s2);
        boolean strCompResult2 = s1 == s2;
        boolean strCompResult3 = s1 != s2;
        boolean strCompResult4 = !s1.equals(s2);

        System.out.println(result);
        System.out.println(result2);
        System.out.println(result3);

    }
}
