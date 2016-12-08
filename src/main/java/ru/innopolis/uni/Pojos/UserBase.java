package ru.innopolis.uni.Pojos;

import ru.innopolis.uni.Pojos.UserInterface;

/**
 * Created by olymp on 01.12.2016.
 */
abstract public class UserBase implements UserInterface {
    protected void copy(UserInterface ui) {
        setPasshash(ui.getPasshash());
        setEmail(ui.getEmail());
        setUsername(ui.getUsername());
        setName(ui.getName());
        setId(ui.getId());
    }
    protected String name,
            username,
            email,
            passhash;
    protected long id;


}
