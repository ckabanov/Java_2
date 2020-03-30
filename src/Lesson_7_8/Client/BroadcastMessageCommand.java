package Lesson_7_8.Client;

import java.io.Serializable;

public class BroadcastMessageCommand implements Serializable {

    private final String message;

    public BroadcastMessageCommand(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
