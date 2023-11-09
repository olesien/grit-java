package org.linus;

public class Main {
    public static void main(String[] args) {
        String test = "est";

        stringMethods();

    }

    private static void stringMethods() {
        String str = "    Vi är glada java programmerare!";
        str = str.trim();
        System.out.println(str);

        char chr = str.charAt(6);
        System.out.println(chr);

        boolean equal = str.equals("1111");

        boolean contains = str.contains("Vi är glada");
        System.out.println(contains);
    }
}