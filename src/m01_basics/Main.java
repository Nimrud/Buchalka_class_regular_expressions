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

        // zastępowanie Lower/UpperCase jednym wariantem:
        // (niezależnie, czy wyraz jest napisany małą czy wielką literą - będzie zmieniony w 1 standard)
        System.out.println("harry".replaceAll("[hH]arry", "Harry"));

        // zastępowanie każdej litery oprócz wymienionej:
        System.out.println(alphanumeric.replaceAll("[^ey]", "_"));

        // zastępowanie znaków z pewnego zakresu:
        System.out.println(alphanumeric.replaceAll("[a-f3-8]", "+"));

        // zastąpienie liter - z ignorowaniem wielkości (np. a-A):
        System.out.println(alphanumeric.replaceAll("(?i)[a-f3-8]", "="));
        // (?i) działa ze stringami w formacie ASCII
        // dla Unicode i ASCII stosujemy polecenie (?iu)

        // zastąpienie wszystkich cyfr w stringu:
        System.out.println(alphanumeric.replaceAll("[0-9]", "#"));
        // lub:
        System.out.println(alphanumeric.replaceAll("\\d", "#"));

        // zastąpienie wszystkich znaków niebędących cyframi:
        System.out.println(alphanumeric.replaceAll("\\D", "@"));

        String hasWhiteSpace = "I have blanks and\ta tab, and also a new line\n.";
        System.out.println(hasWhiteSpace);

        // usuwanie białych znaków:
        System.out.println(hasWhiteSpace.replaceAll("\\s", ""));

        // tabulator: \\t
        // cyfra: \\d
        // nie-cyfra: \\D
        // podział linii: \\n
        // wszystkie znaki poza białymi znakami: \\S
        // dowolna mała/wielka litera, cyfra lub dolne podkreślenie: \\w

        // usuwanie wszystkich małych liter, wielkich liter, cyfr oraz dolnego podkreślenia:
        System.out.println(hasWhiteSpace.replaceAll("\\w", "!"));

        // dodawanie znaków wokół np. słów rozdzielonych białymi znakami:
        System.out.println(hasWhiteSpace.replaceAll("\\b", "\""));
    }
}
