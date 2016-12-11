package ru.innopolis.uni.dao;

import ru.innopolis.uni.Pojos.ItemInterface;

import java.util.List;

/**
 * Created by olymp on 28.11.2016.
 */
public interface ItemsDao {
    void addItem(ItemInterface itemModel);

    void removeItem(ItemInterface item);

    List<ItemInterface> getItems(long userId, String listName);
}
