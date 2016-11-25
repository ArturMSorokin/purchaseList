package ru.innopolis.uni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

/**
 * Created by olymp on 18.11.2016.
 */
public class RegisterServlet extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(RegisterServlet.class) ;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("doGet????");
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            Class.forName("org.h2.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test7");
                 Statement statement = connection.createStatement();) {
                ForTest:
                {
                    statement.execute("CREATE TABLE IF NOT Users(username VARCHAR(255) primary key,name VARCHAR(255)," +
                            " email VARCHAR(255),passhash BIGINT);");
                    statement.execute("insert into Product (username, name, email,passhash) " +
                            "values ('sdf','sfff','email@email.ru',8457483958);");
                }

                if (req.getParameter("liName")==null) {//this is login
                    String liUserName = (String)req.getAttribute("liUserName");
                    ResultSet resultSet = statement.executeQuery("select passhash from Users where name="+req.getAttribute("liUserName")+";");
                    if (resultSet.next() && req.getAttribute("liPassword")!=null && resultSet.getLong(1)==Long.parseLong((String)req.getAttribute("liPassword"))) {
                        resp.addCookie(new Cookie("user",liUserName));
                    }
                } else { //this is registration
                    statement.executeQuery()
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        logger.info("post added !!!!"+req.getParameter("liName")+"  username:"+req.getParameter("liUserName")
        +"   \nEmail:"+req.getParameter("liEmail")+"    Pass:"+req.getParameter("liPassword"));
    }
}
