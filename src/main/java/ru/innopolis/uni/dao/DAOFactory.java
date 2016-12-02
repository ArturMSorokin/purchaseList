package ru.innopolis.uni.dao;

import ru.innopolis.nikn.models.dao.StudentDAO;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Nikolay on 22.11.2016.
 */
public interface DAOFactory {
    public Connection getConnection() throws SQLException;
}
