package ru.innopolis.uni.dao;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManagerFactory;

/**
 * Created by MrArtur on 11.12.2016.
 */
public class EntityKeeper {
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }
}
