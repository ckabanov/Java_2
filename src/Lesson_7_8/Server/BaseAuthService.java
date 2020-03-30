package Lesson_7_8.Server;

import java.util.ArrayList;
import java.util.List;

public class BaseAuthService implements AuthService {
    private class UserData  {
        private String login;
        private String pass;
        private String nick;

        public UserData (String login, String pass, String nick) {
            this.login = login;
            this.pass = pass;
            this.nick = nick;
        }
    }

    private List<UserData > entries;

    @Override
    public void start() {
        System.out.println("Сервис аутентификации запущен");
    }

    @Override
    public void stop() {
        System.out.println("Сервис аутентификации остановлен");
    }


    public BaseAuthService() {
        entries = new ArrayList<>();
        entries.add(new UserData ("login1", "pass1", "nick1"));
        entries.add(new UserData ("login2", "pass2", "nick2"));
        entries.add(new UserData ("login3", "pass3", "nick3"));
    }

    @Override
    public String getUsernameByLoginAndPassword(String login, String pass) {
        for (UserData  o : entries) {
            if (o.login.equals(login) && o.pass.equals(pass)) return o.nick;
        }
        return null;
    }
}