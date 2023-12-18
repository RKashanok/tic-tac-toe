package pl.roka.variables;

public class LogicalTypes {
    public static void main(String[] args) {

        // boolean
        // type, name;
        // type, name, '=' , value
        // type name1, name2, name3;
        String a = " ";
        String b = new String(" ");
        String c = new String(new char[]{'a', 'b', 'c'});

        boolean myBoolean = true;
        Boolean myBoolean2 = false;

        boolean maybeTrue = 5 > 3;
        boolean maybeFalse = a == b;
        boolean maybeFalse2 = a.equals(b);

        System.out.println(maybeTrue);
        System.out.println(maybeFalse);
        System.out.println(maybeFalse2);

    }
}
