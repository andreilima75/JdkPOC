package org.example;

public class Jdk26Poc {

    static void main() throws Exception {

        primitivePatterns();

    }

    static void primitivePatterns() {
        System.out.println("1. Primitive Patterns + instanceof/switch:");
        Object value = 42;

        switch (value) {
            case int i when i > 0 -> System.out.println("  Positive int: " + i);
            case double d -> System.out.println("  Double: " + d);
            default -> System.out.println("  Other");
        }

        if (value instanceof int i) {
            System.out.println("  instanceof primitive: " + i);
        }
        System.out.println();
    }

}