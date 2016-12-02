package ru.innopolis.uni.dao;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.innopolis.uni.Pojos.UserModel;
import static org.junit.Assert.assertTrue;

/**
 * Created by MrArtur on 02.12.2016.
 */
public class UserDaoImpTest {

    UserModel userModel = new UserModel(21,"xname1",
            "xusername1","xemail1","xpasshash1");
    UserModel userModel2 = new UserModel(22,"xname2",
            "xusername2","xemail2","xpasshash2");
    static Logger log = LoggerFactory.getLogger(UserDaoImpTest.class);
    static UserDao userDao = new UserDaoImp();
    @BeforeClass
    public static void beforeTest(){
        log.info("This is @BeforeClass method");

    }

    @Before
    public  void before() {

    }
    @Test
    public  void Test1() {
        userDao.addUpdateUser(userModel);
        UserModel um = userDao.getUser(userModel.getUsername());
        assertTrue("getted from database first user",userModel.equals(um));
    }
    @Test
    public  void Test2() {
        userDao.addUpdateUser(userModel);
        UserModel um = userDao.getUser(userModel.getUsername());
        assertTrue("getted from database second user",userModel.equals(um));
    }
    @AfterClass
    public static void afterClass() {

    }

}
