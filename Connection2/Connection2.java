package Connection2;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection2 {
    public static void main(String[] args) {
        Class<Driver>driverClass = Driver.class;
        // create new database
        String sql = """
                CREATE TABLE IF NOT EXISTS info(
                id SERIAL PRIMARY KEY ,
                data TEXT NOT NULL);
                """;


        try {
            Connection connection = ConnectionManager.open();
            //открываю statement после connection.метод create statement + try catch
            var statement = connection.createStatement();
            System.out.println(connection.getTransactionIsolation());
             var executeResult = statement.execute(sql);   //for ddl operation
            System.out.println(executeResult);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
//////