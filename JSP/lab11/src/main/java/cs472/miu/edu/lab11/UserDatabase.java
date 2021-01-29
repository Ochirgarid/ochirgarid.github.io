package cs472.miu.edu.lab11;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static List<User> users = new ArrayList<>();
    private static UserDatabase instance;
    static {
        instance = new UserDatabase();
    }

    private UserDatabase() {
        users.add(new User("admin", "admin"));
        users.add(new User("ochirgarid", "password123"));
        users.add(new User("test", "123"));
    }

    public boolean isUserExists(String username, String password) {
        return users.stream().anyMatch(
                user -> user.checkCredentials(username, password)
        );
    }

    public static UserDatabase getInstance(){
        return instance;
    }
}
