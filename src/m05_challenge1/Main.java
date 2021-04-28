package m05_challenge1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Challenge 1a
        // Write a regular expression that will match "I want a bike." and "I want a ball."
        String challenge1a = "I want a bike.";
        String challenge1b = "I want a ball.";
        String solution1 = "I want a b.{3}.";
        System.out.println(challenge1a.matches(solution1));
        System.out.println(challenge1b.matches(solution1));
        String solution1b = "I want a (bike|ball).";  // alternatywne rozwiązanie

        // Challenge 1b
        // In the previous challenge, we used the same regular expression twice
        // Use the Matcher.matches() method to check for matches, instead of String.matches()
        // Hint: you'll have to compile a pattern
        System.out.println("=== Challenge 1b ===");
        Pattern pattern1b = Pattern.compile(solution1);

        Matcher matcher1ba = pattern1b.matcher(challenge1a);
        System.out.println(matcher1ba.matches());

        Matcher matcher1bb = pattern1b.matcher(challenge1b);
        System.out.println(matcher1bb.matches());

        // Challenge 1c
        // Replace all occurrences of blank with an underscore
        System.out.println("=== Challenge 1c ===");
        String challenge1c = "Replace all blanks with underscores.";
        System.out.println(challenge1c.replaceAll("[ ]", "_"));

        // Challenge 1d
        // Write a regular expression that will match the following string in its entirety
        System.out.println("=== Challenge 1d ===");
        String challenge1d = "aaabccccccccdddefffg";
        String solution1da = "[a-g]{20}";       // uproszczona wersja
        System.out.println(challenge1d.matches(solution1da));
        String solution1db = "^a{3}bc{8}d{3}ef{3}g$";   // pełna wersja
        System.out.println(challenge1d.matches(solution1db));

        // Challenge 1e
        // Write a regular expression that will match a string that starts with a series of letters
        // The letters must be followed by a period
        // After the period, there must be a series of digits
        // The string "abcd.135" would match, "f5.12a" would not
        System.out.println("=== Challenge 1e ===");
        String challenge1ea = "abcd.135";
        String challenge1eb = "f5.12a";
        String solution1e = "^[a-z|A-Z]+\\.\\d+$";
        System.out.println(challenge1ea.matches(solution1e));
        System.out.println(challenge1eb.matches(solution1e));
    }
}
