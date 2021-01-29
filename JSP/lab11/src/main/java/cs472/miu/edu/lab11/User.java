package cs472.miu.edu.lab11;

import java.util.Locale;

public class User {
    private String username;
    private String password;
    User(String uname, String pass){
        username = uname;
        password = pass;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean checkCredentials(String uname, String pass){
        return username.toLowerCase().equals(uname.toLowerCase()) && password.equals(pass);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
