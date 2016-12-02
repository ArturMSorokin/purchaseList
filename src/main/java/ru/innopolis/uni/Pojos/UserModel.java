package ru.innopolis.uni.Pojos;

import ru.innopolis.uni.Pojos.UserBase;

/**
 * Created by olymp on 28.11.2016.
 */
public class UserModel extends UserBase{

    public UserModel() {
    }

    public UserModel(String name, String username, String email, String passhash,long id) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.passhash = passhash;
        this.id=id;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
