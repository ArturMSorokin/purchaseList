package ru.innopolis.uni;

/**
 * Created by olymp on 28.11.2016.
 */
public class User {
    private String name,
            username,
            email,
            passhash;

    public User() {
    }

    public User(String name, String username, String email, String passhash) {

        this.name = name;
        this.username = username;
        this.email = email;
        this.passhash = passhash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }
}
