<%@ page import="ua.org.oa._dani4_.model.Library" %><%--
  Created by IntelliJ IDEA.
  User: Levsha
  Date: 24.03.2016
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddBook</title>
</head>

<body>
<%
    String bookCount = request.getParameter("new_book_count");
    String bookAuthor = request.getParameter("new_book_author");
    String bookTitle = request.getParameter("new_book_title");
    if (bookAuthor != null && bookTitle != null) {
        Library library = (Library)session.getAttribute("library");
        int count = bookCount != null? Integer.parseInt(bookCount) : 0;
        library.addBook(bookAuthor, bookTitle, count);
    }
    request.setAttribute("new_book_count", null);
    request.setAttribute("new_book_author", null);
    request.setAttribute("new_book_title", null);
    request.getRequestDispatcher("addbook.jsp").forward(request, response);

%>
</body>
</html>