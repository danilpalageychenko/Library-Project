<%--
  Created by IntelliJ IDEA.
  User: Levsha
  Date: 29.03.2016
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>qwe
<head>
    <title>DelBook</title>
</head>
<body>
<p> <b> Can't delete book <%=request.getParameter("del_book")%> </b></p>

<form name="gobackButton" method="get" action="admin.jsp">
    <input type="submit" name="gobackButton" value="OK"/>
</form>
</body>
</html>