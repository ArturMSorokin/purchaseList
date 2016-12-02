package ru.innopolis.uni.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.Pojos.UserModel;

import java.sql.*;
import java.util.Formatter;
import java.util.Locale;

/**
 * Created by MrArtur on 01.12.2016.
 */
public class UserDaoImp implements UserDao {
    private static final  String tableName="public.users";
    private  String PREPARED_ADD;
    private  String PREPARED_GETUSER ;
    private  String PREPARED_RMUSER;
    private  String PREPARED_CREATEIFNOTEXISTS = "create table if not exists public.users ( item text primary key);";
    Logger log = LoggerFactory.getLogger(getClass());
    UserDaoImp() {
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder, Locale.US);
        formatter.format("REPLACE into %s (id, name, username, email, passhash) values(?,?,?,?,?);",tableName);
        PREPARED_ADD=stringBuilder.toString();

        stringBuilder.delete(0,stringBuilder.length());
        formatter.format("select * from %s where username=(?);",tableName);
        PREPARED_GETUSER=stringBuilder.toString();

        stringBuilder.delete(0,stringBuilder.length());
        formatter.format("DELETE FROM %s WHERE username=(?);",tableName);
        PREPARED_RMUSER =stringBuilder.toString();

        execute(PREPARED_CREATEIFNOTEXISTS);
    }

    private void execute(String sql) {
        try ( Connection connection = ConnectionProviderImpl.getProvider().getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ) {
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
    }

    private UserModel buildUser(ResultSet rs) throws SQLException {
        UserModel user = new UserModel();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPasshash(rs.getString("passhash"));
        return user;
    }

    public void rmUser(String username) {
        try ( Connection connection = ConnectionProviderImpl.getProvider().getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(PREPARED_RMUSER);
        ) {
            preparedStatement.setString(1,username);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            log.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
    }

    public void addUpdateUser(UserModel userModel) {
        try ( Connection connection = ConnectionProviderImpl.getProvider().getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(PREPARED_ADD);
        ) {
            preparedStatement.setLong(1,userModel.getId());
            preparedStatement.setString(2,userModel.getName());
            preparedStatement.setString(3,userModel.getUsername());
            preparedStatement.setString(4,userModel.getEmail());
            preparedStatement.setString(5,userModel.getPasshash());
            preparedStatement.execute();
        } catch (SQLException e) {
            log.error(e.getMessage());
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
    }

    public UserModel getUser(String userName) {
        try ( Connection connection = ConnectionProviderImpl.getProvider().getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(PREPARED_GETUSER);
            ) {
            preparedStatement.setString(1,userName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
                return buildUser(resultSet);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
