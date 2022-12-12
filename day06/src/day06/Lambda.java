package day06;

import java.util.List;

public class Lambda {

    public static void apply(Greetings greeting, String value) {
        greeting.hello(value);
    }

    public static void toUpperCase(String str) {
        System.out.printf(">>> %s = %s\n", str, str.toUpperCase());
    }
    
    public static void main(String[] args) {
        // (name) => { }
        Greetings hi = (n) -> {
            System.out.printf("Hello %s\n", n);
        };

        hi.hello("Fred");

        List<String> names = List.of("fred", "barney", "wilma", "betty");
        System.out.printf("Say hello to %s\n", names);
        for (String n: names)
            apply(hi, n);

        toUpperCase("hello, world");

        Greetings reverseCase = Lambda::toUpperCase;
        System.out.printf("To uppercase %s\n", names);
        for (String n: names)
            apply(reverseCase, n);
    }
}
