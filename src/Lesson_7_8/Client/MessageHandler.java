package Lesson_7_8.Client;

@FunctionalInterface
public interface MessageHandler {
    void handle(String message);
}
