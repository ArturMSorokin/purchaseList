package ru.innopolis.uni.Pojos;

/**

 * Created by MrArtur on 08.12.2016.
 */
abstract public class ItemBase implements ItemInterface{
    protected ItemBase(ItemInterface item) {
        this.id=item.getId();
        this.userId=item.getUserId();
        this.listName=item.getListName();
        this.item=item.getItem();
    }
    protected ItemBase() {
    }
    protected long id;
    protected long userId;
    protected String listName;
    protected String item;

    @Override
    public boolean equals(ItemInterface obj) {
        return (id==obj.getId() &&
                    userId==obj.getUserId() &&
                    listName==obj.getListName() &&
                    item==obj.getItem());
    }
}
