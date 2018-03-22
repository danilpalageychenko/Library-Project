package ua.org.oa._dani4_.service.impl;

import ua.org.oa._dani4_.dao.Dao;
import ua.org.oa._dani4_.dao.daoImpl.BookDaoSqlImpl;
import ua.org.oa._dani4_.model.dto.BookDTO;
import ua.org.oa._dani4_.model.elements.Book;
import ua.org.oa._dani4_.properties.PropertyUtils;
import ua.org.oa._dani4_.service.IBookService;
import ua.org.oa._dani4_.transform.Transformer;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Admin on 03.04.2016.
 */
public class BookServiceImpl implements IBookService<BookDTO> {

    private static BookServiceImpl bookService;
    private Dao<Book> bookDAO = fetchDAO();
    private BookServiceImpl() { }
    private Dao<Book> fetchDAO() {
        Dao<Book> bookDAO = null;
        Properties properties = PropertyUtils.getProperties();
        String value = properties.getProperty("DB");
        switch (value) {
            case "JDBC":
                bookDAO = new BookDaoSqlImpl();
                break;
        }
        return bookDAO;
    }

    public synchronized static BookServiceImpl getInstance() {
        if (bookService == null) {
            bookService = new BookServiceImpl();
        }
        return bookService;
    }


    @Override
    public BookDTO findById(int id) {
        Book bookById = bookDAO.read(id);
        return Transformer.transformBook(bookById);
    }

    @Override
    public int create(BookDTO bookDTO) {
        Book book = Transformer.transformBookDTO(bookDTO);
        return bookDAO.create(book).getId();
    }

    @Override
    public boolean update (BookDTO bookDTO) {
        Book book = Transformer.transformBookDTO(bookDTO);
        return bookDAO.update(bookDTO.getId(), book);
    }

    @Override
    public List<BookDTO> getAll() {
        List<BookDTO> books = new ArrayList<>();
        for (Book book : bookDAO.getAll()) {
            books.add(Transformer.transformBook(book));
        }
        return books;
    }

    @Override
    public boolean delete(int id) {
        return bookDAO.delete(id);
    }


}
