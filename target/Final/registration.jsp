<%@ page import="ua.org.oa._dani4_.model.Library" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.org.oa._dani4_.model.dto.UserDTO" %><%--
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
<p><b> Registration </b></p>
<form name="registrationForm" method="get" action="registeruser.jsp">
    Input login: <input type="text" name="new_user_login"/> </br>
    Input password: <input type="password" name="new_user_pass"/> </br>
    Input name: <input type="text" name="new_user_name"/> </br>
    Input date of your birthday [YYYY-MM-DD]: <input type="text" name="new_user_birth"/></br>
    <input type="submit" name="registrationButton" value="Register me!"/>

</form>
<form name="registrationFormCancel" method="get" action="index.jsp">
    <input type="submit" name="cancelButton" value="Cancel"/>
</form>
</body>
</html>