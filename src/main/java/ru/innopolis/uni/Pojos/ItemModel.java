package ru.innopolis.uni.Pojos;

/**
 * Created by olymp on 05.12.2016.
 */
public class ItemModel extends ItemBase {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
