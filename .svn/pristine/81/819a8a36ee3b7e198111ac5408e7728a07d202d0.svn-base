package ua.org.oa._dani4_.model;

import ua.org.oa._dani4_.exceptions.NoAvaliableBookException;
import ua.org.oa._dani4_.exceptions.NoAvaliableReportException;
import ua.org.oa._dani4_.model.dto.BookDTO;
import ua.org.oa._dani4_.model.dto.ReportDTO;
import ua.org.oa._dani4_.model.dto.UserDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 03.04.2016.
 */
public interface ILibraryServises {
    List getBookDtoList();
    List<ReportDTO> getReportDtoList();
    List<UserDTO> getUserDtoList();
    int addUser(Date birthday, String login, String name, String password);
    UserDTO findUser(int index);
    UserDTO findUser(String login, String password);
    boolean deleteUser(int index);
    int addBook(String author, String title, int count);
    boolean deleteBook(int index);
    BookDTO findBook(int index);

    int takeBook(int book_id, Date date, int user_id) throws NoAvaliableBookException;

    int giveBackBook(int user_id, int book_id, Date date) throws NoAvaliableReportException;

}
