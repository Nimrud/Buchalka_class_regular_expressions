package m03_Pattern_Matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // klasy Pattern i Matcher - do manipulacji stringami
        // Pattern.compile() - konwersja regular expression do Pattern,
        // w celu dalszej pracy z klasą Matcher
        // Matcher - gdy chcemy znaleźć wiele wystąpień danego wzoru (pattern),
        // albo gdy chcemy użyć tego samego wzory wiele razy

        StringBuilder htmlText = new StringBuilder("<h1>The Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph.</p>");
        htmlText.append("<p>This is another paragraph.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = ".*<h2>.*";   // szukamy <h2> otoczonego dowolną liczbą innych znaków
        Pattern pattern = Pattern.compile(h2Pattern,
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        Matcher matcher= pattern.matcher(htmlText);
            // Matcher porównuje wyrażenie do CAŁEGO stringa!
            // więc trzeba szukaną frazę obudować .*
        System.out.println(matcher.matches());
    }
}
