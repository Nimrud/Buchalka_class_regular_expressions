package m01_basics;

public class Main {
    public static void main(String[] args) {
        String s1 = "Mike is hungry. Mike looks for a banana.";
        System.out.println(s1.replaceAll("Mike", "Ann"));

        // Wildcard:
        String alphanumeric = "abcDeKJyII127ato7z2";
        System.out.println(alphanumeric.replaceAll(".", "y"));
        // kropka zastępuje 1 dowolny znak - stąd nazwa (Dzika Karta)

        // Caret Boundary Matcher:
        System.out.println(alphanumeric.replaceAll("^abcDe", "aa"));
        // kareta (^) wskazuje na ciąg znaków, który ma być zastąpiony
        // ten ciąg musi być początkiem stringa (!)

        // metoda .matches() zwraca true/false
        System.out.println(alphanumeric.matches("^hi"));
        System.out.println(alphanumeric.matches("^abc"));
        // uwaga - metoda jest błędna: cały string musi się zgadzać! (ignoruje ^)

        // Dollar Boundary Matcher - sprawdza koniec stringa
        System.out.println(alphanumeric.replaceAll("o7z2$", "THE END"));

        // zastępowanie wszystkich wystąpień danego znaku []
        System.out.println(alphanumeric.replaceAll("[aze]", "*"));

        // zastępowanie znaku, jeśli jest przed innym znakiem:
        System.out.println(alphanumeric.replaceAll("[ae][Kt]", "---"));
        // tu zastąpimy każdą literę a lub e, ale tylko jeśli za nią jest K lub t
    }
}
