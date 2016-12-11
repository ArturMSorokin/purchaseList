package ru.innopolis.uni.entity;

import ru.innopolis.uni.Pojos.UserBase;
import ru.innopolis.uni.Pojos.UserInterface;
import ru.innopolis.uni.Pojos.UserModel;

import javax.persistence.*;

/**
 * Created by olymp on 01.12.2016.
 */
@Entity
public class User extends UserBase {

    public User(UserInterface ui) {
        super(ui);
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
    @Override
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }
    @Override
    @Column
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }
    @Override
    @Column
    public String getUsername() {
        return username;
    }
    @Override
    public void setUsername(String username) {
        this.username = username;
    }
    @Override
    @Column
    public String getEmail() {
        return email;
    }
    @Override
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    @Column
    public String getPasshash() {
        return passhash;
    }
    @Override
    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }
}
