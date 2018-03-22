package ua.org.oa._dani4_.dao.daoImpl;

import ua.org.oa._dani4_.dao.Dao;
import ua.org.oa._dani4_.model.elements.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.org.oa._dani4_.jdbc.ConnectionProvider.getConnection;
import static ua.org.oa._dani4_.jdbc.SQLs.*;

/**
 * Created by Admin on 03.04.2016.
 */
public class UserDaoSqlImpl implements Dao<User> {
    @Override
    public User create(User user) {
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_USER_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setDate(1, new Date(user.getBirthday().getTime()));
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getName());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) user.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public User read(int id) {
        User user = null;
        try (PreparedStatement pt1 = getConnection().prepareStatement(SQL_USER_SELECT_BY_ID)) {
            pt1.setInt(1, id);
            ResultSet rs = pt1.executeQuery();
            if (rs.next()) {
                java.util.Date birthday = rs.getDate("birthday") != null? new java.util.Date (rs.getDate("birthday").getTime()) : null;
                user = new User(birthday, rs.getString("login"), rs.getString("name"), rs.getString("password"));
                user.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = new ArrayList<>();
        try (Statement st = getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(SQL_USER_SELECT_ALL);
            User user;
            while (rs.next()) {
                java.util.Date birthday = rs.getDate("birthday") != null? new java.util.Date (rs.getDate("birthday").getTime()) : null;
                user = new User(birthday, rs.getString("login"), rs.getString("name"), rs.getString("password"));
                user.setId(rs.getInt("id"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public boolean update(int index, User user) {
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_USER_UPDATE_BY_ID)) {
            ps.setDate(1, new Date(user.getBirthday().getTime()));
            ps.setString(2, user.getLogin());
            ps.setString(3, user.getName());
            ps.setString(4, user.getPassword());
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_USER_DELETE_BY_ID)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}