package Lesson_7_8.Client;

import java.io.Serializable;
import java.util.List;

public class UpdateUsersListCommand implements Serializable {

    private final List<String> users;

    public UpdateUsersListCommand(List<String> users) {
        this.users = users;
    }

    public List<String> getUsers() {
        return users;
    }
}