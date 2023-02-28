package Connection;

import com.mysql.jdbc.Driver;

public class ConnectionCheker {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
