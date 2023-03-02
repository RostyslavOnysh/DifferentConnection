package Connection2;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connection2 {
    public static void main(String[] args) {
        Class<Driver> driverClass = Driver.class;
        /* create new database
        String sql = """
               CREATE TABLE IF NOT EXISTS info(
                id SERIAL PRIMARY KEY ,
                data TEXT NOT NULL);
               """; */


                                           // insert
               /*   String sql = """
                    INSERT INTO info (data)
                    VALUES
                    ('Test1'),
                     ('Test2'),
                      ('Test3'),
                        ('Test4')
                                   """;
                */

                /*     String sql = """
                        UPDATE info
                         SET data = 'TestTest'
                           WHERE id = 4
                                           """;
                 */

        String sql = """
                SELECT * FROM testbase

                """;

        try {
            Connection connection = ConnectionManager.open();
            //открываю statement после connection.метод create statement + try catch
            var statement = connection.createStatement();
            System.out.println(connection.getTransactionIsolation());
            var executeResult = statement.executeQuery(sql);
            // var executeResult = statement.execute(sql);   //for ddl operation
            while (executeResult.next()) {
                System.out.println(executeResult.getLong("id"));
                System.out.println(executeResult.getString("name"));
                System.out.println(executeResult.getString("value"));
                System.out.println("---------");
            }
            System.out.println(executeResult);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}


// через (execute) только true or false;
//есть метод для возврата количества обновленных строк
// sout(statement.getUpdateCount());
// ResultSet похож на iterator
//шоб вывести результат выборки нада юзать цикл while (executeResult.next()){sout(executeResult.getLong(id))}