package com.example.examplecors.api;

import lombok.var;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(name = "item", urlPatterns = "/item",
        initParams = {
                @WebInitParam(name = "db-user", value = "root"),
                @WebInitParam(name = "db-pw", value = "1234"),
                @WebInitParam(name = "db-url", value = "jdbc:mysql://localhost:3306/pos24?createDatabaseIfNotExist=true"),
                @WebInitParam(name = "db-class", value = "com.mysql.cj.jdbc.Driver"),
        },
        loadOnStartup = 10
)
public class Item extends HttpServlet {
    Connection connection;
    private static final String SAVE_DATA = "INSERT INTO ITEM (itcode, itname, itprice, itqty)";

    @Override
    public void init() throws ServletException {
        System.out.println("");
        try {
            var user = getServletConfig().getInitParameter("db-user");
            var password = getServletConfig().getInitParameter("db-pw");
            var url = getServletConfig().getInitParameter("db-url");
//            var dbClass = getServletConfig().getInitParameter("db-class");

            Class.forName(getServletConfig().getInitParameter("db-class"));
            this.connection = DriverManager.getConnection(url, user, password);

            System.out.println(user);
            System.out.println(password);
            System.out.println(url);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }



}
