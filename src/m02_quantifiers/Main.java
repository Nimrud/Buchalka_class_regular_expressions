package m02_quantifiers;

public class Main {
    public static void main(String[] args) {

        String aN = "abcDeeeKJyZhiij127ato7kz2";

        // Quantifier określa, ile razy dany element może wystąpić w danym regular expression
        // liczba w {} określa, ile razy poprzedni znak ma wystąpić:
        System.out.println(aN.replaceAll("^abcDe{3}", "replace"));

        // inna wersja, z + (plus mówi, że może to być jeden - lub więcej - dany znak)
        // plus dotyczy tylko znaku poprzedzającego
        System.out.println(aN.replaceAll("^abcDe+", "replace"));

        // szukamy 0+ wystąpień znaku:
        // gwiazdka - jak zwykle - dotyczy tylko znaku ją poprzedzającego
        System.out.println(aN.replaceAll("^abcDe*", "replace"));
        // przydatne np. gdy robimy walidację informacji podanych przez użytkownika,
        // ale część z nich jest opcjonalna

        // ograniczenie liczby wystąpień znaku do danego zakresu (np. od 2 do 5 znaków e):
        System.out.println(aN.replaceAll("^abcDe{2,5}", "replace"));

        // przykład zamiany:
        // wszystkich wystąpień znaku h, za którym jest dowolna ilość i,
        // przynajmniej jedno j - zamieniamy taki ciąg na _
        System.out.println(aN.replaceAll("[h]i*j+", "_"));

        // zamiana znaków a-z, oprócz j oraz k
        System.out.println(aN.replaceAll("[a-z&&[^jk]]", "-"));

        // 0 lub 1 wystąpień: ?
        // np. [a-d]?

        // PEŁNA DOKUMENTACJA:
        // https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html
    }
}
