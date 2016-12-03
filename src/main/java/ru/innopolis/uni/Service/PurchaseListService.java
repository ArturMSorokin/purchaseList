package ru.innopolis.uni.Service;

import java.util.List;

/**
 * Created by MrArtur on 02.12.2016.
 */
public interface PurchaseListService {
    void addItem(String item);

    void removeItem(String item);

    public List<String> getItems() ;
}
