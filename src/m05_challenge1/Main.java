package m05_challenge1;

public class Main {
    public static void main(String[] args) {
        // Challenge 1
        // write a regular expression that will match "I want a bike." and "I want a ball."
        String challenge1a = "I want a bike.";
        String challenge1b = "I want a ball.";
        String solution1 = "I want a b.{3}.";
        System.out.println(challenge1a.matches(solution1));
        System.out.println(challenge1b.matches(solution1));
    }
}
