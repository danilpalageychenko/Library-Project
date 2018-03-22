<%--
  Created by IntelliJ IDEA.
  User: Levsha
  Date: 24.03.2016
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration successful</title>
</head>
<body>
<% if ((session.getAttribute("user_id") == null) || (session.getAttribute("user_name") == "")) { %>

<p>You are not logged in! </p>
<a href="index.jsp">Please Login</a>

<% } else { %>

<p>Welcome <%=session.getAttribute("user_name")%> !</p>
<a href="logout.jsp">Log out</a>
<%    } %>
</body>
</html>