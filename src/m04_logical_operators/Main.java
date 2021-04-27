package m04_logical_operators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        // operator OR (|)
        String harry = "harry";
        System.out.println(harry.replaceAll("[H|h]arry", "Larry"));

        // operator NOT (!)
        // [^abc] - kareta w nawiasie kwadratowym: każdy znak oprócz wymienionych
        // druga wersja na przykładzie (znalezienie wszystkich t, za którymi nie ma v):

        String tvTest = "tstvtkt";

        // za pomocą zapisu "t[^v]" nie wykryjemy wszystkich wystąpień w powyższym stringu
        // ponieważ nie wykryje ono ostatniego t
        // zapis "t[^v]" oznacza bowiem, że szukamy t, za którym znajduje się jakikolwiek znak nie będący v
        // a w stringu za ostatnim t nie ma nic
        // używamy więc tzw. lookahead expression (to może mieć 0 dopasowań):
        String tNotVRegExp = "t(?!v)";       // lookahead expression syntax: (?___)
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        int count = 0;
        while (tNotVMatcher.find()){
            count++;
            System.out.println("Occurrence " + count + ": "
                    + tNotVMatcher.start() + " to " + tNotVMatcher.end() + ": "
                    + tNotVMatcher.group(0));
                    // wynik POMIJA znaki z lookahead expression (czyli wyświetla samo t)
        }

        // znalezienie każdego t, za którym jest v, ale bez zwrócenia v:
        // t(?=v)

        // Przykład - walidacja numeru telefonu z USA, np. (800) 123-4567:
        System.out.println("=== US phone number validation ===");
        String phoneNumberPattern = "^([\\(]{1}[0-9]{3}[\\)]{1}[ ]{1}[0-9]{3}[\\-]{1}[0-9]{4})$";
        // ^ - string musi się tu zaczynać (nie może być przed tym innych znaków)
        // [\\(] - otwarcie nawiasu, poprzedzone \\ (bez tego nawias oznacza Grupę)
        // {1} dokładnie 1 wystąpienie otwarcia nawiasu
        // [0-9]{3} - 2 kolejno występujące po sobie cyfry
        // [ ]{1} - dokładnie 1 spacja
        // $ - string musi się tym kończyć - jeśli jest coś po tym, to cała fraza nie jest numerem telefonu
        String phone1 = "1234567890";
        String phone2 = "123 456-7890";       // brak nawiasu
        String phone3 = "(123) 456-7890";     // OK
        String phone4 = "(123)456-7890";      // brak spacji po nawiasie

        System.out.println("phone1: " + phone1.matches(phoneNumberPattern));
        System.out.println("phone2: " + phone2.matches(phoneNumberPattern));
        System.out.println("phone3: " + phone3.matches(phoneNumberPattern));
        System.out.println("phone4: " + phone4.matches(phoneNumberPattern));

        // Przykład - walidacja numeru karty VISA:
        System.out.println("=== VISA card validation ===");
        // numery zaczynają się od cyfry 4
        // stare karty mają 13 cyfr
        // nowe 16 cyfr
        String visaPattern = "^4[0-9]{12}([0-9]{3})?$";
        // ([0-9]{3})? - opcjonalne 3 cyfry dla nowych kart
        // ()? = oznacza 0 lub więcej wystąpień danej Grupy

        String visa1 = "4444444444444";      // OK
        String visa2 = "5444444444444";      // nie zaczyna się od 4
        String visa3 = "44444444444447";     // zła liczba cyfr
        String visa4 = "4444444444444777";   // OK

        System.out.println("visa1: " + visa1.matches(visaPattern));
        System.out.println("visa2: " + visa2.matches(visaPattern));
        System.out.println("visa3: " + visa3.matches(visaPattern));
        System.out.println("visa4: " + visa4.matches(visaPattern));
    }
}
