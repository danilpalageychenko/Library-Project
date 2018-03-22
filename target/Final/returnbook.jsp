<%@ page import="ua.org.oa._dani4_.exceptions.NoAvaliableReportException" %>
<%@ page import="ua.org.oa._dani4_.model.Library" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.time.LocalDate" %>
<%--
  Created by IntelliJ IDEA.
  User: Levsha
  Date: 24.03.2016
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ReturnBook</title>
</head>

<body>
<%
    try {
        Library library = (Library) session.getAttribute("library");
        int report_id = Integer.parseInt(request.getParameter("report_return_book"));
        int user_id = (Integer) session.getAttribute("user_id");
        library.giveBackBook(user_id, report_id, Date.valueOf(LocalDate.now()));
    } catch (NoAvaliableReportException | Exception ex) {
        request.getRequestDispatcher("returnbookerror.jsp").forward(request, response);
    }
    request.setAttribute("returned_book", null);
    request.getRequestDispatcher("library.jsp").forward(request, response);
%>
</body>
</html>