package ru.innopolis.uni.dao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


/**
 * Created by MrArtur on 01.12.2016.
 */
public class ItemsDaoImp {
    private  String PREPARED_ADDITEM;
    private  String PREPARED_RMITEM;
    private  String PREPARED_CREATEIFNOTEXISTS;
    private  String PREPARED_GETALL;
    Logger log = LoggerFactory.getLogger(getClass());

    public ItemsDaoImp(String userName, String listName) {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder, Locale.US);
        formatter.format("REPLACE into public.%s.%s (items) values(?);",userName,listName);
        PREPARED_ADDITEM = stringBuilder.toString();

        stringBuilder.delete(0,stringBuilder.length());
        formatter.format("create table if not exists public.%s.%s ( item text primary key);",userName,listName);
        PREPARED_CREATEIFNOTEXISTS = stringBuilder.toString();

        stringBuilder.delete(0,stringBuilder.length());
        formatter.format("DELETE FROM public.%s.%s WHERE item=(?);",userName,listName);
        PREPARED_RMITEM=stringBuilder.toString();

        stringBuilder.delete(0,stringBuilder.length());
        formatter.format("select * FROM public.%s.%s;",userName,listName);
        PREPARED_GETALL=stringBuilder.toString();

        execute(new String[0],PREPARED_CREATEIFNOTEXISTS);

    } //first listName = default

    private void execute(String[] items, String prepared) {
        try (Connection connection = ConnectionProviderImpl.getProvider().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(prepared);
        ) {
            for (int i=0; i<items.length; ++i)
                preparedStatement.setString(i,items[i]);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
    }
    public void addItem(String[] item) {
        execute(item, PREPARED_ADDITEM);
    }

    public void removeItem(String[] item) {
        execute(item,PREPARED_RMITEM);
    }

    /**
     * Gets all items from list
     * @return list of items, empty if  error ocurred or table empty.
     */
    public List<String> getItems() {
        List<String> items = new LinkedList<>();
        try (Connection connection = ConnectionProviderImpl.getProvider().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(PREPARED_GETALL);
        ) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
                items.add(resultSet.getString(1));
        } catch (SQLException e) {
            log.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        return items;
    }
}
