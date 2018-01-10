package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Egor Stepanov
 * @since 12/10/2017.
 */
public class Main {

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/testdb", "postgres", "postgres");
            System.out.println("Connection established.");
            PreparedStatement statement = connection.prepareStatement("select * from account");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException exc) {
            System.out.println("Connection failed! " + exc);
        }
    }
}
