package Lesson_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private Map<String, List<String>> book = new HashMap<>();

    public void add(String surname, String phoneNumber) {
        List<String> phoneNumberList;
        if (book.containsKey(surname)) {
            phoneNumberList = book.get(surname);
        } else {
            phoneNumberList = new ArrayList<>();
        }
        phoneNumberList.add(phoneNumber);
        book.put(surname, phoneNumberList);
    }

    public List<String> get(String surname) {
        return book.get(surname);
    }
}