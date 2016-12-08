package ru.innopolis.uni.Pojos;

/**
 * Created by olymp on 01.12.2016.
 */
public interface UserInterface {
    public UserInterface toModel();
    public UserInterface toEntity();
    public String getName();
    public void setName(String name);
    public String getUsername();
    public void setUsername(String username);
    public String getEmail();
    public void setEmail(String email);
    public String getPasshash();
    public void setPasshash(String passhash);
    public long getId();
    public void setId(long id);
}
