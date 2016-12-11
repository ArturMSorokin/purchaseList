package ru.innopolis.uni.Pojos;

import ru.innopolis.uni.entity.Item;

/**
 * Created by MrArtur on 08.12.2016.
 */
public class ItemModel extends ItemBase {

    public ItemModel() {
    }
    public ItemModel(ItemInterface itemInterface) {
        super(itemInterface);
    }

    @Override
    public ItemInterface toModel() {
        return this;
    }

    @Override
    public ItemInterface toEntity() {
        return new Item(this);
    }

    @Override
    public long getId() {
        return id;
    }
    @Override
    public void setId(long id) {
        this.id = id;
    }
    @Override
    public long getUserId() {
        return userId;
    }
    @Override
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getListName() {
        return listName;
    }
    @Override
    public void setListName(String listName) {
        this.listName = listName;
    }
    @Override
    public String getItem() {
        return item;
    }
    @Override
    public void setItem(String item) {
        this.item = item;
    }
}
