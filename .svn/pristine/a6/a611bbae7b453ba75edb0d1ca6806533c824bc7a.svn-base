package ua.org.oa._dani4_.dao.daoImpl;

import ua.org.oa._dani4_.dao.Dao;
import ua.org.oa._dani4_.model.elements.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static ua.org.oa._dani4_.jdbc.ConnectionProvider.getConnection;
import static ua.org.oa._dani4_.jdbc.SQLs.*;

/**
 * Created by Admin on 03.04.2016.
 */
public class BookDaoSqlImpl implements Dao<Book>{
    @Override
    public Book create(Book book) {
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_BOOK_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, book.getAuthor());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getCount());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) book.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    @Override
    public Book read(int id) {
        Book book = null;
        try (PreparedStatement pt1 = getConnection().prepareStatement(SQL_BOOK_SELECT_BY_ID)) {
            pt1.setInt(1, id);
            ResultSet rs1 = pt1.executeQuery();
            if (rs1.next()) {
                book = new Book(rs1.getString("author"), rs1.getString("title"), rs1.getInt("count"));
                book.setId(rs1.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public List<Book> getAll() {
        List<Book> bookList = new ArrayList<>();
        try (Statement st = getConnection().createStatement()) {
            ResultSet rs2 = st.executeQuery(SQL_BOOK_SELECT_ALL);
            Book book;
            while (rs2.next()) {
                book = new Book(rs2.getString("author"), rs2.getString("title"), rs2.getInt("count"));
                book.setId(rs2.getInt("id"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public boolean update(int id, Book book) {
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_BOOK_UPDATE_BY_ID)) {
            ps.setString(1, book.getAuthor());
            ps.setString(2, book.getTitle());
            ps.setInt(3, book.getCount());
            ps.setInt(4, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement pt = getConnection().prepareStatement(SQL_BOOK_DELETE_BY_ID)) {
            pt.setInt(1, id);
            return pt.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}