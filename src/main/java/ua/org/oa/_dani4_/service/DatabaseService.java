package ua.org.oa._dani4_.service;

        import java.sql.SQLException;
        import java.sql.Statement;

        import static ua.org.oa._dani4_.jdbc.ConnectionProvider.getConnection;
        import static ua.org.oa._dani4_.jdbc.SQLs.*;

/**
 * Created by _dani on 30.03.2016.
 */
public class DatabaseService {
    public static void initDatabase() {

//        try (Statement st = getConnection().createStatement()) {
//            st.execute(SQL_DROP_STUDENT);
//            st.execute(SQL_DROP_GROUP);
//            st.execute(SQL_CREATE_GROUP);
//            st.execute(SQL_CREATE_STUDENT);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
