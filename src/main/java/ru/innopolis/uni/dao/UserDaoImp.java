package ru.innopolis.uni.dao;

import com.sun.corba.se.impl.copyobject.CopierManagerImpl;
import ru.innopolis.uni.Pojos.UserModel;

import java.sql.*;

/**
 * Created by MrArtur on 01.12.2016.
 */
public class UserDaoImp implements UserDao {
    private static final  String tableName="users";
    private static final String PREPARED_ADD="REPLACE into "+tableName+" (id, name, username, email, passhash) " +
            "values(?,?,?,?,?)";
    private static final String PREPARED_GETUSER="select * from "+tableName+" where username=(?)" ;
    private UserModel buildUser(ResultSet rs) throws SQLException {
        UserModel user = new UserModel();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setEmail(rs.getString("email"));
        user.setPasshash(rs.getString("passhash"));
        return user;
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
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return null;
    }
}
