package ru.innopolis.uni.dao;

import ru.innopolis.uni.Pojos.ItemInterface;
import ru.innopolis.uni.Pojos.UserModel;
import ru.innopolis.uni.entity.User;

import java.util.List;

/**
 * Created by MrArtur on 11.12.2016.
 */
public class UserDaoHib extends EntityFactoryKeeper implements UserDao {
    @Override
    public void addUpdateUser(UserModel userModel) {

    }
    @Override
    public UserModel getUser(String userName) {
        return null;
    }

    @Override
    public void rmUser(String user ) {

    }
}
