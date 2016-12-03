package ru.innopolis.uni.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.uni.dao.ItemsDao;

import java.util.List;

/**
 * Created by MrArtur on 02.12.2016.
 */
@Service
public class PurchaseListServiceImp implements  PurchaseListService {
    @Autowired
    ItemsDao itemsDao;

    public void setItemsDao(ItemsDao itemsDao) {
        this.itemsDao = itemsDao;
    }

    @Override
    public void addItem(String item) {
        itemsDao.addItem(item);
    }

    @Override
    public void removeItem(String item) {
        itemsDao.removeItem(item);
    }

    @Override
    public List<String> getItems() {
        List<String> list = itemsDao.getItems();
        return list;
    }
}
