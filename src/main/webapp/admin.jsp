<%@ page import="ua.org.oa._dani4_.model.Library" %>
<%@ page import="java.util.List" %>
<%@ page import="ua.org.oa._dani4_.model.dto.ReportDTO" %>
<%@ page import="ua.org.oa._dani4_.model.dto.BookDTO" %>
<%@ page import="ua.org.oa._dani4_.model.dto.UserDTO" %>
<%@ page import="java.text.DateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Levsha
  Date: 24.03.2016
  Time: 23:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AdminsPage</title>
</head>

<%!
    Library library;
    List<BookDTO> books;
    List<ReportDTO> reports;
    List<UserDTO> users;

    String fillBookTable() {
        books = library.getBookDtoList();
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\">");
        sb.append("<tr> <td>Book ID</td> <td>Author</td> <td>Title</td> <td>Count</td> </tr>");
        if (books == null) {
            sb.append("<tr> <td> no books. </td> </tr>");
        } else {
            books.forEach(book -> sb.append("<tr> <td>")
                    .append(book.getId()).append("</td> <td> ")
                    .append(book.getAuthor()).append(" </td> <td> ")
                    .append(book.getTitle()).append(" </td> <td> ")
                    .append(book.getCount()).append(" </td> </tr>"));
        }
        sb.append("</table>");
        return sb.toString();
    }

    String fillReportTable() {
        reports = library.getReportDtoList();
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\">");
        sb.append("<tr> <td>Report ID</td> <td>Author</td> <td>Title</td> <td>User login</td> <td>Rent date</td>" +
                " <td>Return date</td> </tr>");
        if (reports == null) {
            sb.append("<tr><td> don't have archive reports.</td> </tr>");
        } else {
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            for (ReportDTO report : reports) {
                if (report.getReturns() != null) {
                    i++;
                    BookDTO book = library.findBook(report.getBookID());
                    UserDTO user = library.findUser(report.getUserID());
                    String bookTitle = book == null ? "deleted" : book.getTitle();
                    String bookAuthor = book == null ? "deleted" : book.getAuthor();
                    String login = user == null ? "deleted" : user.getLogin();
                    sb2.append("<tr> <td>").append(report.getId()).append("</td> <td> ")
                            .append(bookAuthor).append(" </td> <td> ")
                            .append(bookTitle).append(" </td> <td> ")
                            .append(login).append(" </td> <td> ")
                            .append(DateFormat.getDateInstance().format(report.getRent())).append(" </td> <td> ")
                            .append(DateFormat.getDateInstance().format(report.getReturns())).append(" </td> </tr>");
                }

            }
            if (i==0) {
                sb.append("<tr><td> don't have returned reports.</td> </tr>");
            } else {sb.append(sb2);}
        }
        sb.append("</table>");
        return sb.toString();
    }

    String fillReportTableNotReturned() {
        reports = library.getReportDtoList();
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\">");
        sb.append("<tr> <td>Report ID</td> <td>Author</td> <td>Title</td> <td>User name</td> <td>Rent date</td> </tr>");
        if (reports == null) {
            sb.append("<tr> <td> don't have any rented books. </td> </tr>");
        } else {
            StringBuilder sb2 = new StringBuilder();
            int i = 0;
            for (ReportDTO report : reports) {
                if (report.getReturns() == null) {
                    i++;
                    BookDTO book = library.findBook(report.getBookID());
                    UserDTO user = library.findUser(report.getUserID());
                    String bookAuthor = book == null ? "deleted" : book.getAuthor();
                    String bookTitle = book == null ? "deleted" : book.getTitle();
                    String login = user == null ? "deleted" : user.getLogin();
                    sb.append("<tr> <td>").append(report.getId()).append("</td> <td> ")
                            .append(bookAuthor).append(" </td> <td> ")
                            .append(bookTitle).append(" </td> <td> ")
                            .append(login).append(" </td> <td> ")
                            .append(DateFormat.getDateInstance().format(report.getRent())).append(" </td> </tr>");
                }
            }
            if (i==0) {
                sb.append("<tr><td> don't have rented books.</td> </tr>");
            } else {sb.append(sb2);}
        }
        sb.append("</table>");
        return sb.toString();
    }

    String fillUsersTable() {
        users = library.getUserDtoList();
        StringBuilder sb = new StringBuilder();
        sb.append("<table border=\"1\">");
        sb.append("<tr> <td>User ID</td> <td>Name</td> <td>Login</td> <td>Password</td> <td>Birthday</td> </tr>\n");
        if (users == null) {
            sb.append("<tr> <td> don't have users. </td> </tr>");
        } else {
            for (UserDTO user : users) {
                String birth = user.getBirthday() != null ? DateFormat.getDateInstance().format(user.getBirthday()) : null;
                sb.append("<tr> <td>").append(user.getId()).append("</td> <td> ")
                        .append(user.getName()).append(" </td> <td> ")
                        .append(user.getLogin()).append(" </td> <td> ")
                        .append(user.getPassword()).append(" </td> <td> ")
                        .append(birth).append(" </td> </tr>");

            }
        }
        sb.append("</table>");
        return sb.toString();
    }

%>

<body>
<%library = (Library) session.getAttribute("library");%>

<p>Archive reports:</p>
<%=fillReportTable()%>

<p>Actual reports:</p>
<%=fillReportTableNotReturned()%>

<p>Books:</p>
<%=fillBookTable()%>
<form name="deleteBookForm" method="get" action="delbook.jsp">
    Choose book to delete (ID): <input type="number" name="del_book"/></br>
    <input type="submit" name="deleteBookButton" value="Delete book"/></br>
</form>
<form name="addBookForm" method="get" action="addbook.jsp">
    <input type="submit" name="addBookButton" value="Add book"/></br>
</form>

<p>Users:</p>
<%=fillUsersTable()%> </br>


<input type="button" value="Refresh" onclick='window.location.reload()'> </br>


<form name="logoutForm" method="get" action="logout.jsp">
    <input type="submit" name="logoutButton" value="Logout"/>
</form>
</body>
</html>