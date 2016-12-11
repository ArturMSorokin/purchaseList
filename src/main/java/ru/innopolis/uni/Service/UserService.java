package ru.innopolis.uni.Service;

import ru.innopolis.uni.Pojos.UserModel;

/**
 * Created by MrArtur on 11.12.2016.
 */
public interface UserService {
    public void addUpdateUser(UserModel userModel);
    public UserModel getUser(String userName);
    public void rmUser(String user);
}
