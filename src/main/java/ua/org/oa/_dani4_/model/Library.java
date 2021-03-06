package ua.org.oa._dani4_.model;

import ua.org.oa._dani4_.exceptions.NoAvaliableBookException;
import ua.org.oa._dani4_.exceptions.NoAvaliableReportException;
import ua.org.oa._dani4_.model.dto.BookDTO;
import ua.org.oa._dani4_.model.dto.ReportDTO;
import ua.org.oa._dani4_.model.dto.UserDTO;
import ua.org.oa._dani4_.service.IBookService;
import ua.org.oa._dani4_.service.IReportService;
import ua.org.oa._dani4_.service.IUserService;
import ua.org.oa._dani4_.service.impl.BookServiceImpl;
import ua.org.oa._dani4_.service.impl.ReportServiceImpl;
import ua.org.oa._dani4_.service.impl.UserServiceImpl;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 03.04.2016.
 */
public class Library implements ILibraryServises {
    private IUserService userService = UserServiceImpl.getInstance();
    private IBookService bookService = BookServiceImpl.getInstance();
    private IReportService reportService = ReportServiceImpl.getInstance();

    public synchronized IUserService getUserService() {
        return userService;
    }
    public synchronized IBookService getBookService() {
        return bookService;
    }

    public synchronized IReportService getReportService() {
        return reportService;
    }


    public synchronized List<BookDTO> getBookDtoList() {        return getBookService().getAll();    }

    public synchronized List<ReportDTO> getReportDtoList() {
        return getReportService().getAll();
    }

    public synchronized List<UserDTO> getUserDtoList() {
        return getUserService().getAll();
    }

    @Override
    public synchronized int addUser(Date birthday, String login, String name, String password) {
        return getUserService().create(new UserDTO(birthday, login, name, password));
    }

    @Override
    public boolean deleteUser(int index) {
        return getUserService().delete(index);

    }

    @Override
    public synchronized UserDTO findUser(int id) {
        for (UserDTO user : getUserDtoList()) {
            if (user.getId() == id) return user;
        }
        return null;
    }

    @Override
    public synchronized UserDTO findUser(String login, String password) {
        for (UserDTO user : getUserDtoList()) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) return user;
        }
        return null;
    }

    @Override
    public synchronized int addBook(String author, String title, int count) {
        return getBookService().create(new BookDTO(author, title, count));
    }

    @Override
    public synchronized boolean deleteBook(int index) {
        return getBookService().delete(index);
    }

    @Override
    public synchronized BookDTO findBook(int id) {
        for (BookDTO book : getBookDtoList()) {
            if (book.getId() == id) return book;
        }
        return null;
    }


    @Override
    public synchronized int takeBook(int book_id, Date date, int user_id) throws NoAvaliableBookException {
        ReportDTO report;
        int report_id = -1;
        try {
            BookDTO book = (BookDTO)getBookService().findById(book_id);
            if (book == null) throw new NoAvaliableBookException();
            UserDTO user = (UserDTO)getUserService().findById(user_id);
            int count = book.getCount() - 1;
            if (count > -1) {
                book.setCount(count);
                report = new ReportDTO(book.getId(), date, user.getId(), null);
                getBookService().update(book);
                getReportService().create(report);
                report_id = report.getId();
            }
        } catch (Exception ex) {
            //report_id = -1;
        }
        return report_id;
    }

    @Override
    public synchronized int giveBackBook(int user_id, int report_id, Date date) throws NoAvaliableReportException {
        int book_id = -1;
        try {
            ReportDTO report = (ReportDTO)getReportService().findById(report_id);
            if (report == null) throw new NoAvaliableReportException();
            BookDTO book = (BookDTO)getBookService().findById(report.getBookID());
            report.setReturns(date);
            getReportService().update(report);
            int count = book.getCount() + 1;
            book.setCount(count);
            getBookService().update(book);
            book_id = book.getId();
        } catch (Exception ex) {
            //...
        }
        return book_id;
    }

}