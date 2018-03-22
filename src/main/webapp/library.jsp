<%@ page import="ua.org.oa._dani4_.model.Library" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.org.oa._dani4_.properties.PropertyUtils" %>
<%@ page import="ua.org.oa._dani4_.model.dto.UserDTO" %>
<%@ page import="ua.org.oa._dani4_.model.dto.ReportDTO" %>
<%@ page import="ua.org.oa._dani4_.model.dto.BookDTO" %>
<%@ page import="java.text.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Levsha
  Date: 26.03.2016
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LIBRARY</title>
</head>

<%!
    Library library;
    List<ReportDTO> reports;
    List<BookDTO> books;

    String avaliableBookTable() {
        StringBuilder sb = new StringBuilder();
        books = library.getBookDtoList();
        sb.append("<table border=\"1\">");
        sb.append("<tr> <td>Book ID</td> <td>Author</td> <td>Title</td> <td>Count</td> </tr>");
        if (books == null) {
            sb.append("<tr> <td> no books. </td> </tr>");
        } else {
            books.forEach(book -> sb.append("<tr> <td>").append(book.getId()).append("</td> <td> ")
                    .append(book.getAuthor()).append(" </td> <td> ")
                    .append(book.getTitle()).append(" </td> <td> ")
                    .append(book.getCount()).append(" </td> </tr>"));
        }
        sb.append("</table>");
        return sb.toString();
    }

    String fillReportTableAboutRentedBooks(int id) {
        StringBuilder sb = new StringBuilder();
        reports = library.getReportDtoList();
        UserDTO user = library.findUser(id);
        sb.append("<table border=\"1\">");
        sb.append("<tr> <td>Report ID</td> <td>Author</td> <td>Title</td> <td>User name</td> <td>Rent date</td> </tr>");
        if (reports == null) {
            sb.append("<tr> <td> don't have any rented books. </td> </tr>");
        } else {
            for (ReportDTO report : reports) {
                if (user.getId() == report.getUserID() && report.getReturns() == null) {
                    BookDTO book = library.findBook(report.getBookID());
                    String rent = DateFormat.getDateInstance().format(report.getRent());
                    sb.append("<tr> <td>").append(report.getId()).append("</td> <td> ")
                            .append(book.getTitle()).append(" </td> <td> ")
                            .append(user.getLogin()).append(" </td> <td> ")
                            .append(user.getName()).append(" </td> <td> ")
                            .append(rent).append(" </td> </tr>");
                }
            }
        }
        sb.append("</table>");
        return sb.toString();
    }

%>

<body>
<%library = (Library) session.getAttribute("library");%>
<p>Hello, <%=session.getAttribute("user_name")%>!</p>

<p>List of books in library:</p>
<%=avaliableBookTable()%>

<form name="rentForm" method="get" action="rentbook.jsp">
    Choose book to rent (ID): <input title="input id" type="number" name="rent_book"/>
    <input type="submit" name="rentButton" value="Rent book"/>
</form>

<p>Books in rent now:</p>
<%=fillReportTableAboutRentedBooks((Integer) session.getAttribute("user_id"))%>

<form name="returnForm" method="get" action="returnbook.jsp">
    Choose book to return (report_ID): <input title="input id" type="number" name="report_return_book"/>
    <input type="submit" name="returnButton" value="Return book"/>
</form>

<input type="button" value="Refresh" onclick='window.location.reload()'> </br>

<form name="logoutForm" method="get" action="logout.jsp">
    <input type="submit" name="logoutButton" value="Logout"/>
</form>

</body>
</html>