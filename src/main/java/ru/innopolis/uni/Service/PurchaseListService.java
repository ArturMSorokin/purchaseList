package ru.innopolis.uni.Service;

import javax.enterprise.inject.Model;
import java.util.List;
import java.util.Map;

/**
 * Created by MrArtur on 02.12.2016.
 */
public interface PurchaseListService {
    /**
     *
     * @param username
     * @return returns values
     */
    void getItems(String username, String listName, Map<String, Object> model);
    String addItem(String username, String listName, String item);
    void rmItem(String username, String listName, String item);

}
