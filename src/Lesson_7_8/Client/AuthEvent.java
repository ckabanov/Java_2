package Lesson_7_8.Client;

@FunctionalInterface
public interface AuthEvent {
    void authIsSuccessful(String nickname);
}
