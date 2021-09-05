package jdbcexample.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnectionProvider {

    private static DbConnectionProvider provider = new DbConnectionProvider();

    private static  final String DB_URL="jdbc:mysql:\\localhost:3306\\test_jdbc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static  final String DB_USERNAME= "root";
    private static  final String DB_PASSWORD= "root";

    private DbConnectionProvider(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static DbConnectionProvider grtProvider(){
        return provider;
    }

    public Connection getConnection(){

        try {
            DriverManager.getConnection(DB_URL,DB_USERNAME,DB_PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }
}
