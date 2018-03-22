<%--
  Created by IntelliJ IDEA.
  User: Levsha
  Date: 24.03.2016
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logout</title>
</head>
<body>
<%
    session.setAttribute("user_name", null);
    session.setAttribute("user_id", null);
    session.setAttribute("library", null);
    session.invalidate();
    request.getRequestDispatcher("index.jsp").forward(request, response);
%>
</body>
</html>