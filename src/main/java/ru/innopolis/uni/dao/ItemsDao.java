package ru.innopolis.uni.dao;

import java.util.List;

/**
 * Created by olymp on 28.11.2016.
 */
public interface ItemsDao {
    public void addItem(String[] item);
    public void removeItem(String[] item);
    public List<String> getItems() ;
}
