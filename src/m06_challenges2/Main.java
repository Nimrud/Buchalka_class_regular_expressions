package m06_challenges2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // Challenge 2a
        // Write a regular expression that will print all digits from a string
        // which follows the pattern:
        // a series of letters, followed by a period, followed by a series of digits
        // That pattern can occur multiple times in this string
        String challenge2a = "abcd.135uvqz.7tzik.999";
        String solution2a = "([a-z|A-Z]+)(\\.)(\\d+)";
        Pattern pattern2a = Pattern.compile(solution2a);
        Matcher matcher2a = pattern2a.matcher(challenge2a);
        while (matcher2a.find()) {
            System.out.println("Number: " + matcher2a.group(3));
        }

        // Challenge 2b
        // Let's suppose we're reading strings that match the pattern from challenge2a from a file
        // Tabs are used to separate the matches, with one exception
        // The last match is followed by a new line
        // Revise the regular expression accordingly and extract all the numbers
        System.out.println("=== Challenge 2b ===");
        String challenge2b = "abcd.135\tuvqz.7\ttzik.989\n";
        String solution2b = "[a-z|A-Z]+\\.(\\d+)[\\t|\\n]";
        Pattern pattern2b = Pattern.compile(solution2b);
        Matcher matcher2b = pattern2b.matcher(challenge2b);
        while (matcher2b.find()) {
            System.out.println("Number: " + matcher2b.group(1));
        }

        // Challenge 2c
        // Instead of printing numbers, print out their start and end indices
        // Make these indices inclusive
        // Hint: you'll need to look at the documentation for the methods
        // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Matcher.html
        System.out.println("=== Challenge 2c ===");
        matcher2b.reset();
        while (matcher2b.find()) {
            System.out.println("Start index: " + matcher2b.start(1)
                    + ", end index: " + (matcher2b.end(1) - 1));
            // dla end() odejmujemy 1, bo ta metoda zwraca indeks nast??puj??cy po odnalezionej frazie
        }

        // Challenge 2d
        // We have the following string containing points on a graph within curly braces
        // Extract what's in the curly braces
        System.out.println("=== Challenge 2d ===");
        String challenge2d = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        String solution2d = "\\{(\\d+, \\d+)\\}[, ]*";
        // rozwi??zanie Buchalki:
        // String solution2d = "\\{(.+?)\\}";
        Pattern pattern2d = Pattern.compile(solution2d);
        Matcher matcher2d = pattern2d.matcher(challenge2d);
        while (matcher2d.find()) {
            System.out.println("Numbers: " + matcher2d.group(1));
        }

        // Challenge 2e
        // Write a regular expression that will match a 5-digit US zip code
        // Use '11111' as your test string
        System.out.println("=== Challenge 2e ===");
        String challenge2e = "11111";
        String solution2e = "^\\d{5}$";
        System.out.println(challenge2e.matches(solution2e));

        // Challenge 2f
        // US zip codes can be followed by a dash and another four numbers
        // Write a regular expression that will match those zip codes
        System.out.println("=== Challenge 2f ===");
        String challenge2f = "11111-1111";
        String solution2f = "^\\d{5}(-\\d{4})?$";
        System.out.println(challenge2f.matches(solution2f));

    }
}
