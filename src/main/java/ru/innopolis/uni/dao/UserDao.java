package ru.innopolis.uni.dao;

import ru.innopolis.uni.Pojos.UserModel;

/**
 * Created by olymp on 28.11.2016.
 */
public interface UserDao {
    public void addUpdateUser(UserModel userModel) ;
    public UserModel getUser(String userName) ;
