<%@ page import="ua.org.oa._dani4_.exceptions.RegisterNewUserExcetion" %>
<%@ page import="ua.org.oa._dani4_.model.Library" %>
<%@ page import="ua.org.oa._dani4_.model.dto.UserDTO" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Levsha
  Date: 24.03.2016
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>

<body>
<%
    Library library = new Library();
    List<UserDTO> users = library.getUserDtoList();
    try {
        String login = request.getParameter("new_user_login");
        String password = request.getParameter("new_user_pass");
        if (login == null || password == null) {
            request.getRequestDispatcher("registration.jsp").forward(request, response);
        } else {
            String[] birth = request.getParameter("new_user_birth").split("-");
            System.out.println(request.getParameter("new_user_birth"));
            Date birthday;
            try {
                int year = Integer.parseInt(birth[0]);
                int month = Integer.parseInt(birth[1]);
                int day = Integer.parseInt(birth[2]);
                birthday = new Date(year - 1900, month, day);
            } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException ex) {
                birthday = null;
            }
            String name = request.getParameter("new_user_name");
            for (UserDTO user : users) {
                if (user.getLogin().equals(login)) throw new RegisterNewUserExcetion();
            }
            library.addUser(birthday, login, name, password);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
    } catch (RegisterNewUserExcetion ex) {
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
%>
</body>
</html>