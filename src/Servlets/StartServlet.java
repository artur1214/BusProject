package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by User on 22.07.2018.
 */
public class StartServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("index.jsp");
        ArrayList users = null;
        try {
            EasyDB db = connectDB("postgres", "wasd123wasd5" , "javaTest");
            users = db.MakeQuerry("SELECT \"Name\", \"Password\", \"ID\", \"FullName\"\n" +
                    "  FROM \"Users\";\n");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("users", users);
        System.out.println(users);
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected EasyDB connectDB(String login, String pass, String dbName) throws SQLException {
        return new EasyDB(dbName, pass, login);
    }

}

