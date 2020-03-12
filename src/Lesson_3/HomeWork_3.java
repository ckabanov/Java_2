package Lesson_3;

import java.util.LinkedHashMap;
import java.util.Map;

public class HomeWork_3 {

    private static final String[] Arrays = {"на", "дворе", "трава", "на траве", "дрова", "не", "руби", "дрова", "на траве", "двора"};

    public static void main(String[] args) {

        System.out.println("Задание 1");

        Map<String, Integer> NewCollection = new LinkedHashMap<>();
        for (String word : Arrays) {
            NewCollection.merge(word, 1, Integer::sum);
        }

        for (String word : NewCollection.keySet()) {
            Integer repeat = NewCollection.get(word);
            System.out.print(word + ": " + repeat + ", " );
        }

        System.out.println();
        System.out.println();
        System.out.println("Задание 2");

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Кабанов", "7234592145622");
        phoneBook.add("Семенова", "545761687");
        phoneBook.add("Деманов", "5378643873");
        phoneBook.add("Кабанов", "32468484");


        System.out.println(phoneBook.get("Кабанов"));
        System.out.println(phoneBook.get("Деманов"));
    }
}


