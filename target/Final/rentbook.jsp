<%@ page import="ua.org.oa._dani4_.exceptions.NoAvaliableBookException" %>
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
    <title>RentBook</title>
</head>

<body>
<%
    try {
        Library library = (Library) session.getAttribute("library");
        String bookId = request.getParameter("rent_book");
        int user_id = (Integer) session.getAttribute("user_id");
        int book_id = bookId != null ? Integer.parseInt(bookId) : 0;
        library.takeBook(book_id, Date.valueOf(LocalDate.now()), user_id);
    } catch (NoAvaliableBookException | Exception ex) {
        request.getRequestDispatcher("rentbookerror.jsp").forward(request, response);
    }
    request.setAttribute("rent_book", null);
    request.getRequestDispatcher("library.jsp").forward(request, response);
%>
</body>
</html>