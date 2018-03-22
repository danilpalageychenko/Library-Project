package ua.org.oa._dani4_.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.org.oa._dani4_.jdbc.SQLs.*;
import static ua.org.oa._dani4_.jdbc.UtilsMySql.executeSqlActions;

/**
 * Created by Admin on 03.04.2016.
 */
@WebServlet(name = "InitDbServlet")
public class InitDbServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String [] actions = {SQL_CREATE, SQL_BOOK_CREATE, SQL_USER_CREATE, SQL_REPORT_CREATE};
        executeSqlActions(actions);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
