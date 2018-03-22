package ua.org.oa._dani4_.transform;


import ua.org.oa._dani4_.model.dto.BookDTO;
import ua.org.oa._dani4_.model.dto.ReportDTO;
import ua.org.oa._dani4_.model.dto.UserDTO;
import ua.org.oa._dani4_.model.elements.Book;
import ua.org.oa._dani4_.model.elements.Report;
import ua.org.oa._dani4_.model.elements.User;

/**
 * Created by Admin on 03.04.2016.
 */
public class Transformer {
    public static Book transformBookDTO(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getAuthor(), bookDTO.getTitle(), bookDTO.getCount());
        book.setId(bookDTO.getId());
        return book;
    }

    public static BookDTO transformBook(Book book) {
        BookDTO bookDTO = new BookDTO(book.getAuthor(), book.getTitle(), book.getCount());
        bookDTO.setId(book.getId());
        return bookDTO;
    }

    public static User transformUserDTO(UserDTO userDTO) {
        User user = new User(userDTO.getBirthday(), userDTO.getLogin(), userDTO.getName(), userDTO.getPassword());
        user.setId(userDTO.getId());
        return user;
    }

    public static UserDTO transformUser(User user) {
        UserDTO userDTO = new UserDTO(user.getBirthday(), user.getLogin(), user.getName(), user.getPassword());
        userDTO.setId(user.getId());
        return userDTO;
    }

    public static Report transformReportDTO(ReportDTO reportDTO) {
        Report report = new Report(reportDTO.getBookID(), reportDTO.getRent(), reportDTO.getUserID(), reportDTO.getReturns());
        report.setId(reportDTO.getId());
        return report;
    }

    public static ReportDTO transformReport(Report report) {
        ReportDTO reportDTO = new ReportDTO(report.getBookID(), report.getRent(), report.getUserID(), report.getReturns());
        reportDTO.setId(report.getId());
        return reportDTO;}
}