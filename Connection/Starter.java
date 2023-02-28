package Connection;

import java.sql.*;

public class Starter {


    private static final String URL = "jdbc:mysql://localhost:3306/testbase";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "admin";

    private static final String DELETE = "DELETE FROM dish WHERE id = ? AND title = ?";


    public static void main(String[] args) {
        System.out.println("Hello");
        // registerDriver();

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = DriverManager.getConnection(URL,LOGIN,PASSWORD);
            statement = connection.prepareStatement(DELETE);

            statement.setString(2,"Tittle");
            statement.setInt(1,1);
            int res = statement.executeUpdate();
            System.out.println(res+" = zero");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                connection.close();
                statement.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
