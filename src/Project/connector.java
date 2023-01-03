package Project;

import java.sql.*;
public class connector {
    Connection c;
    Statement s;
    connector(){
        String url = "jdbc:mysql://localhost:3306/stud_mon_sys";
        String username = "root";
        String password = "chaitanya@12";

        try {
            c = DriverManager.getConnection(url,username,password);
            s = c.createStatement();
        }
        catch (Exception e ){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new connector();

    }
}
