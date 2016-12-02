package ru.innopolis.uni.entity;

import ru.innopolis.uni.Pojos.UserBase;
import ru.innopolis.uni.Pojos.UserModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by olymp on 01.12.2016.
 */
@Entity
public class User extends UserBase {
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    @Column
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

    @Id
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UserModel getUserModel() {return new UserModel();}//!!!
    public void setUserModel() {}
}
