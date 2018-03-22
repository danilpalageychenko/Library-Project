<%@ page import="ua.org.oa._dani4_.model.Library" %>
<%@ page import="ua.org.oa._dani4_.properties.PropertyUtils" %>
<%@ page import="ua.org.oa._dani4_.model.dto.UserDTO" %>
<%--
  Created by IntelliJ IDEA.
  User: Levsha
  Date: 24.03.2016
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login actions</title>
</head>
<body>
<%
    String login = request.getParameter("login");
    String psw = request.getParameter("password");
    String adminLogin;
    String adminPassword;
    try {
        adminLogin = PropertyUtils.getProperties().getProperty("admin_login");
        adminPassword = PropertyUtils.getProperties().getProperty("admin_password");
        if (login.equals(adminLogin) && psw.equals(adminPassword)) {
            session.setAttribute("user_name", adminLogin);
            session.setAttribute("user_id", 0);
            session.setAttribute("library", new Library());
            request.getRequestDispatcher("admin.jsp").forward(request, response);
        } else {
            Library library = new Library();
            UserDTO user = library.findUser(login, psw);
            if (user != null) {
                session.setAttribute("user_name", login);
                session.setAttribute("user_id", user.getId());
                session.setAttribute("library", library);
                request.getRequestDispatcher("library.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("logout.jsp").forward(request, response);
            }
        }
    } catch (Exception ex) {
        response.sendRedirect("logout.jsp");
    }
%>
</body>
</html>