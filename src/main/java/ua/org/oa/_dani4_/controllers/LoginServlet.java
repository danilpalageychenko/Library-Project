package ua.org.oa._dani4_.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ua.org.oa._dani4_.properties.PropertyUtils.getProperties;

/**
 * Created by Admin on 03.04.2016.
 */
@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String login = req.getParameter("login");
//        String psw = req.getParameter("password");
//        String adminLogin = null;
//        String adminPassword = null;
//
//        adminLogin = getProperties().getProperty("admin_login");
//        adminPassword = getProperties().getProperty("admin_password");
//
//        if (login.equals(adminLogin) && psw.equals(adminPassword)) {
//            StudentDao studentDao = new StudentDao();
//            req.getSession().setAttribute("user", studentDao);
//            resp.sendRedirect("/myservlet");
//        } else {
//            req.getRequestDispatcher("/notAuth.jsp").forward(req, resp);
//        }
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
