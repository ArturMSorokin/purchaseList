package ru.innopolis.uni.dao;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by MrArtur on 11.12.2016.
 */
public class EntityFactoryKeeper {
    protected EntityKeeper entityKeeper;
    @Autowired
    public void setEntityKeeper(EntityKeeper entityKeeper) {
        this.entityKeeper = entityKeeper;
    }
}
