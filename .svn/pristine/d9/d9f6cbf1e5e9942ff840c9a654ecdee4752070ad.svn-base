<%@ page import="ua.org.oa._dani4_.model.Library" %>
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
    <title>DelBook</title>
</head>

<body>
<%
    Library library = (Library) session.getAttribute("library");
    String bookId = request.getParameter("del_book");
    int book_id;
    try {
        book_id = Integer.parseInt(bookId);
        library.deleteBook(book_id);
    } catch (Exception ex) {
        request.getRequestDispatcher("delbookerror.jsp").forward(request, response);
    }

    request.setAttribute("del_book", null);
    request.getRequestDispatcher("admin.jsp").forward(request, response);
%>
</body>
</html>