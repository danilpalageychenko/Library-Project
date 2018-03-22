package ua.org.oa._dani4_.dao.daoImpl;

import ua.org.oa._dani4_.dao.Dao;
import ua.org.oa._dani4_.model.elements.Report;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static ua.org.oa._dani4_.jdbc.ConnectionProvider.getConnection;
import static ua.org.oa._dani4_.jdbc.SQLs.*;

/**
 * Created by Admin on 03.04.2016.
 */
public class ReportDaoSqlImpl implements Dao<Report> {
    @Override
    public Report create(Report report) {
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_REPORT_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, report.getBookID());
            ps.setDate(2, new Date(report.getRent().getTime()));
            ps.setInt(3, report.getUserID());
            ps.setDate(4, null);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) report.setId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return report;
    }

    @Override
    public Report read(int id) {
        Report report = null;
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_REPORT_SELECT_BY_ID)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                java.util.Date returns = rs.getDate("returns") != null? new java.util.Date(rs.getDate("returns").getTime()) : null;
                report = new Report(rs.getInt("book_id"), new java.util.Date(rs.getDate("rent").getTime()),
                        rs.getInt("user_id"), returns);
                report.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return report;
    }

    @Override
    public List<Report> getAll() {
        List<Report> reportList = new ArrayList<>();
        try (Statement st = getConnection().createStatement()) {
            ResultSet rs = st.executeQuery(SQL_REPORT_SELECT_ALL);
            while (rs.next()) {
                java.util.Date returns = rs.getDate("returns") != null? new java.util.Date(rs.getDate("returns").getTime()) : null;
                Report report = new Report(rs.getInt("book_id"), new java.util.Date(rs.getDate("rent").getTime()),
                        rs.getInt("user_id"), returns);
                report.setId(rs.getInt("id"));
                reportList.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reportList;
    }

    @Override
    public boolean update(int id, Report report) {
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_REPORT_UPDATE_BY_ID)) {
            ps.setInt(1, report.getBookID());
            ps.setDate(2, new Date(report.getRent().getTime()));
            ps.setInt(3, report.getUserID());
            ps.setDate(4, new Date(report.getReturns().getTime()));
            ps.setInt(5, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try (PreparedStatement ps = getConnection().prepareStatement(SQL_REPORT_DELETE_BY_ID)) {
            ps.setInt(1, id);
            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}