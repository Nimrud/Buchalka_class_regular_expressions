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
            // . (kropka - dowolny znak)
            // * (gwiazdka - dowolna liczba wystąpień poprzedzającego ją znaku)
        System.out.println(matcher.matches());

        // Matcher może być wykorzystany tylko raz!
        // przed ponownym użyciem musi zostać zresetowany ( matcher.reset(); )

        // badanie, ile razy (i gdzie) wystąpiła szukana w stringu fraza:
        String h2pattern2 = "<h2>";    // musi być konkretne zapytanie
        Pattern pattern2 = Pattern.compile(h2pattern2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(htmlText);
        int count = 0;
        while(matcher2.find()){
            count++;
            System.out.println("Occurrence " + count + ": " +
                    matcher2.start() + " to " + matcher2.end());
        }

        // badanie tego samego, ale z wykorzystaniem Grup:
        System.out.println("-- Group Matcher --");
        String h2GroupPattern = "(<h2>.*?</h2>)";   // szukaną frazę otaczamy nawiasami (każdy to osobna grupa)
        // UWAGA! Gwiazdka * to tzw. "greedy quantifier", czyli bierze maksymalną ilość znaków
        // czyli jeśli mamy gwiazdkę pomiędzy dwoma szukanymi wyrażeniami,
        // to szukanie nie zakończy się na pierwszym pasującym wyrażeniu, ale na ostatnim!
        // np. gdy mamy taki kod:
        // <h2> 1 </h2>
        // <h2> 2 </h2>
        // <h2> 3 </h2>
        // to (<h2>.*</h2>) obejmie cały kod od początku do końca, a nie 3 fragmenty
        // w takim wypadku należy zastosować tzw. "lazy quantifier", który szuka do pierwszego pasującego wyrażenia
        // zamiana "greedy" na "lazy" dodanie znaku zapytania po gwiazdce: (<h2>.*?</h2>)
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()){
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        System.out.println("=======");
        String h2TextGroups = "(<h2>)(.+?)(</h2>)";    //w szukanej frazie są 3 grupy
        Pattern h2TextGroupsPattern = Pattern.compile(h2TextGroups);
        Matcher textGroupsMatcher = h2TextGroupsPattern.matcher(htmlText);
        while (textGroupsMatcher.find()){
            System.out.println("Occurrence: " + textGroupsMatcher.group(2));
            // group(2) oznacza, że zwrócona będzie wartość drugiej grupy z szukanej frazy
        }
    }
}
