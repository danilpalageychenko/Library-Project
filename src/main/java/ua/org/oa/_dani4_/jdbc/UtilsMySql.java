package ua.org.oa._dani4_.jdbc;


import java.sql.SQLException;
import java.sql.Statement;

import static ua.org.oa._dani4_.jdbc.ConnectionProvider.getConnection;

/**
 * Created by Admin on 03.04.2016.
 */
public class UtilsMySql {
    public static void executeSqlActions(String [] actions) {
        try (Statement st = getConnection().createStatement()) {
            for (String s : actions) {
                st.execute(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
