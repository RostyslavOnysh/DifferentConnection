package Connection2;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection2 {
    public static void main(String[] args) {
        Class<Driver>driverClass = Driver.class;

        try {
            Connection connection = ConnectionManager.open();
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
