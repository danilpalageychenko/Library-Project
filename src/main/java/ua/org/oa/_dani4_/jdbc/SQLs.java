package ua.org.oa._dani4_.jdbc;

import static ua.org.oa._dani4_.properties.PropertyUtils.getProperties;

/**
 * Created by _dani on 30.03.2016.
 */
public class SQLs {

//    //group
//    public static final String SQL_DROP_GROUP = "DROP TABLE IF EXISTS `group`";
//    public static final String SQL_CREATE_GROUP = "CREATE TABLE " + getProperties().getProperty("JDBC_SCHEMA") + ".`group` (\n " +
//            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
//            "  `number` INT NOT NULL,\n" +
//            "  `department` VARCHAR(50) NOT NULL,\n" +
//            "  PRIMARY KEY (`id`))";
//
//    public static final String SQL_INSERT_GROUP = "INSERT INTO `group`(number, department) VALUES (?, ?)";
//    public static final String SQL_SELECT_GROUP_ALL = "SELECT * FROM `group`";
//    public static final String SQL_SELECT_GROUP_BY_ID = "SELECT * FROM `group` WHERE id = ?";
//    public static final String SQL_UPDATE_GROUP_BY_ID = "UPDATE `group` SET number = ?, department = ? WHERE id = ?";
//    public static final String SQL_DELETE_GROUP_BY_ID = "DELETE FROM `group` WHERE id = ?";
//
//    //student
//    public static final String SQL_DROP_STUDENT = "DROP TABLE IF EXISTS `student`";
//    public static final String SQL_CREATE_STUDENT = "CREATE TABLE " + getProperties().getProperty("JDBC_SCHEMA") + ".`student` (\n" +
//            "  `id` INT NOT NULL AUTO_INCREMENT,\n" +
//            "  `name` VARCHAR(45) NOT NULL,\n" +
//            "  `surname` VARCHAR(45) NOT NULL,\n" +
//            "  `enrolment_date` DATE NOT NULL,\n" +
//            "  `group_id` INT NOT NULL,\n" +
//            "  PRIMARY KEY (`id`), \n" +
//            "  FOREIGN KEY (group_id) REFERENCES `group`(id))";
//
//    public static final String SQL_INSERT_STUDENT = "INSERT INTO `student` (name, surname, enrolment_date, group_id) VALUES (?, ?, ?, ?)";
//    public static final String SQL_SELECT_STUDENT_ALL = "SELECT * FROM  `student`";
//    public static final String SQL_SELECT_STUDENT_BY_ID = "SELECT * FROM  `student` WHERE id = ?";
//    public static final String SQL_UPDATE_STUDENT_BY_ID = "UPDATE `student` SET name = ?, surname = ?, enrolment_date = ?, group_id = ? WHERE id = ?";
//    public static final String SQL_DELETE_STUDENT_BY_ID = "DELETE FROM `student` WHERE id = ?";




//Examples
//    public static final String SQL_INSERT = "INSERT INTO human(name, age) VALUES (?, ?)";
//    public static final String SQL_SELECT_ALL = "SELECT * FROM  human";
//    public static final String SQL_SELECT_BY_ID = "SELECT * FROM  human WHERE id = ?";
//    public static final String SQL_UPDATE_BY_ID = "UPDATE students SET name = ?, age = ? WHERE id = ?";
//    public static final String SQL_DELETE_BY_ID = "DELETE FROM students WHERE id = ?";
//    public static final String SQL_DROP = "DROP TABLE IF EXISTS human";
//    public static final String SQL_CREATE = "CREATE TABLE IF NOT EXISTS human(" + "id int AUTO_INCREMENT primary key, "
//            + "name varchar(256), age int)";


    public static final String SQL_CREATE = "CREATE SCHEMA IF NOT EXISTS `library`";
    public static final String SQL_DROP = "DROP SCHEMA IF EXISTS `library`";

    //Book
    public static final String SQL_BOOK_CREATE = "CREATE TABLE IF NOT EXISTS library.book(id int AUTO_INCREMENT primary key, "
            + "author varchar(256), title varchar(256), count int NOT NULL)";
    public static final String SQL_BOOK_DROP = "DROP TABLE IF EXISTS library.book";
    public static final String SQL_BOOK_INSERT = "INSERT INTO library.book(author, title, count) VALUES (?, ?, ?)";
    public static final String SQL_BOOK_SELECT_ALL = "SELECT * FROM library.book";
    public static final String SQL_BOOK_SELECT_BY_ID = "SELECT * FROM library.book WHERE id = ?";
    public static final String SQL_BOOK_UPDATE_BY_ID = "UPDATE library.book SET author = ?, title = ?, count = ? WHERE id = ?";
    public static final String SQL_BOOK_DELETE_BY_ID = "DELETE FROM library.book WHERE id = ?";

    //User
    public static final String SQL_USER_CREATE = "CREATE TABLE IF NOT EXISTS library.user(id int AUTO_INCREMENT primary key, "
            + "birthday date, login varchar(45) NOT NULL, name varchar(256), password varchar(256) NOT NULL)";
    public static final String SQL_USER_DROP = "DROP TABLE IF EXISTS library.user";
    public static final String SQL_USER_INSERT = "INSERT INTO library.user(birthday, login, name, password) VALUES (?, ?, ?, ?)";
    public static final String SQL_USER_SELECT_ALL = "SELECT * FROM library.user";
    public static final String SQL_USER_SELECT_BY_ID = "SELECT * FROM library.user WHERE id = ?";
    public static final String SQL_USER_UPDATE_BY_ID = "UPDATE library.user SET birthday = ?, login = ?, name = ?, password = ?  WHERE id = ?";
    public static final String SQL_USER_DELETE_BY_ID = "DELETE FROM library.user WHERE id = ?";

    //Report
    public static final String SQL_REPORT_CREATE = "CREATE TABLE IF NOT EXISTS library.report(id int AUTO_INCREMENT primary key, "
            + "book_id int NOT NULL , rent date, user_id int NOT NULL, returns date, " +
            "FOREIGN KEY (book_id) REFERENCES library.book(id), FOREIGN KEY (user_id) REFERENCES library.user(id))";
    public static final String SQL_REPORT_DROP = "DROP TABLE IF EXISTS library.report";
    public static final String SQL_REPORT_INSERT = "INSERT INTO library.report (book_id, rent, user_id, returns) VALUES (?, ?, ?, ?)";
    public static final String SQL_REPORT_SELECT_ALL = "SELECT * FROM library.report";
    public static final String SQL_REPORT_SELECT_BY_ID = "SELECT * FROM library.report WHERE id = ?";
    public static final String SQL_REPORT_UPDATE_BY_ID = "UPDATE library.report SET book_id = ?, rent = ?, user_id = ?, returns = ? WHERE id = ?";
    public static final String SQL_REPORT_DELETE_BY_ID = "DELETE FROM library.report WHERE id = ?";
}
