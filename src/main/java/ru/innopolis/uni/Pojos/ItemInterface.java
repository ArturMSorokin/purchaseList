package ru.innopolis.uni.Pojos;

/**

 * Created by MrArtur on 08.12.2016.
 */
public interface ItemInterface {
    public ItemInterface toModel();
    public ItemInterface toEntity();
    public boolean equals(ItemInterface obj);
    public long getId();
    public void setId(long id);
    public long getUserId() ;
    public void setUserId(long userId);
    public String getListName() ;
    public void setListName(String listName);
    public String getItem();
    public void setItem(String item) ;
}
