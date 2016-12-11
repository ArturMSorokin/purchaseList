package ru.innopolis.uni.entity;
import ru.innopolis.uni.Pojos.*;

import javax.persistence.*;

/**
 * Created by MrArtur on 08.12.2016.
 */
@Entity
public class Item extends ItemBase {
    public Item() { }
    public Item(ItemInterface itemInterface) {
        super(itemInterface);
    }
    @Override
    public ItemInterface toModel() {
        return new ItemModel(this);
    }
    @Override
    public ItemInterface toEntity() {
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
    public long getUserId() {
        return userId;
    }
    @Override
    public void setUserId(long userId) {
        this.userId = userId;
    }
    @Override
    @Column
    public String getListName() {
        return listName;
    }
    @Override
    public void setListName(String listName) {
        this.listName = listName;
    }
    @Override
    @Column
    public String getItem() {
        return item;
    }
    @Override
    public void setItem(String item) {
        this.item = item;
    }
}
