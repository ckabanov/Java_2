package Lesson_7_8.Server;

public interface AuthService {

    String getUsernameByLoginAndPassword(String login, String password);

    void start();
    void stop();

}
