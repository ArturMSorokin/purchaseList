package ru.innopolis.uni.entity;

import ru.innopolis.uni.Pojos.UserBase;
import ru.innopolis.uni.Pojos.UserInterface;
import ru.innopolis.uni.Pojos.UserModel;

import javax.persistence.*;

/**
 * Created by olymp on 01.12.2016.
 */
@Entity
@Table
public class User extends UserBase {

    public User(UserInterface ui) {
        copy(ui);
    }

    public User() {
    }
    @Override
    public UserInterface toModel() {
        return new UserModel(this);
    }

    @Override
    public UserInterface toEntity() {
        return this;
    }

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public void setUserModel() {}
}
