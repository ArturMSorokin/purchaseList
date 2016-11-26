package ru.innopolis.uni;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.List;
import java.util.StringJoiner;

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

    private boolean checkEmptyStrings(String[] params) {
        for (String p : params)
            if (p!=null && p.isEmpty())
                return true;
        return false;
    }

    private void warn(HttpServletRequest req, HttpServletResponse resp, String warning) throws ServletException, IOException {
        req.setAttribute("warningMessage",warning);
        getServletContext().getRequestDispatcher("/registration.jsp").forward(req,resp);
    }

    private void openSession(HttpServletRequest req, HttpServletResponse resp,String userName) {
        OutputStream os = null;
        try {
            os = resp.getOutputStream();
            os.write("<html><body>Hello, world!</body></html>".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //at registration parameter "register" should be
        String liName = (String)req.getParameter("liName");//at registration, else =null
        String liUserName = (String)req.getParameter("liUserName");//at login
        String liEmail = (String)req.getParameter("liEmail");//at registration
        String liPassword = (String)req.getParameter("liPassword");//at login
        String[] fields = {liName,liUserName,liEmail,liPassword};
        if (checkEmptyStrings(fields)) {//if any field empty, return with warning
            warn(req,resp,"Please, fill all fields");
            return;
        }
        String register = (String)req.getParameter("register");

        try {
            Class.forName("org.h2.Driver");
            try (Connection connection = DriverManager.getConnection("jdbc:h2:~/test7");
                 Statement statement = connection.createStatement();) {
                ForTest:
                {
                    statement.execute("CREATE TABLE IF NOT exists  Users(username VARCHAR(255) primary key,name VARCHAR(255), email VARCHAR(255),passhash BIGINT);");
                }

                if (register==null) {//this is login
                    ResultSet resultSet = statement.executeQuery("select passhash from Users where name=" + req.getAttribute("liUserName") + ";");
                    if (resultSet.next() && req.getAttribute("liPassword") != null && resultSet.getLong(1) == Long.parseLong((String) req.getAttribute("liPassword"))) {
                        resp.addCookie(new Cookie("user", liUserName));
                        openSession(req,resp,liUserName);
                    } else {
                        warn(req,resp,"No such user");
                        return;
                    }
                } else { //this is registration
                    statement.executeUpdate("INSERT INTO Users VALUES('"+liUserName+"','"+liName+"','"+liEmail+"',"+liPassword+");");
                    openSession(req, resp, liUserName);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
