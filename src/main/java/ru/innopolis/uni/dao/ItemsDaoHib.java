package ru.innopolis.uni.dao;

import org.springframework.beans.factory.annotation.Autowired;
import ru.innopolis.uni.Pojos.ItemInterface;
import ru.innopolis.uni.Pojos.ItemModel;
import ru.innopolis.uni.entity.Item;
import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MrArtur on 11.12.2016.
 */
public class ItemsDaoHib extends EntityFactoryKeeper implements ItemsDao {
    @Override
    public void addItem(ItemInterface itemModel) {
        EntityManager entityManager = entityKeeper.getEntityManagerFactory().createEntityManager();
        entityManager.merge(itemModel.toEntity());
    }

    @Override
    public void removeItem(ItemInterface item) {
        EntityManager entityManager = entityKeeper.getEntityManagerFactory().createEntityManager();
        entityManager.remove(item.toEntity());
    }

    @Override
    public List<ItemInterface> getItems(long userId, String listName) {
        EntityManager entityManager = entityKeeper.getEntityManagerFactory().createEntityManager();
        List<Item> items =entityManager.createQuery("from Item where userId="+
                userId+" and listName="+listName+";").getResultList();
        List<ItemInterface> models = new ArrayList<>();
        for (Item i : items)
            models.add(i.toModel());
        return models;
    }
}
