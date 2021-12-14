import org.postgresql.Driver;
import ua.tns.employeeproductivity.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;


public class App {
    public static void main(String[] args) throws SQLException {
        Class<Driver> driverClass = Driver.class;
        String SQL = """
                SELECT * FROM test;
                                """;
        try (Connection connection = ConnectionManager.open();
             Statement statement = connection.createStatement()) {
            System.out.println(connection.getTransactionIsolation());
//            boolean execute = statement.execute(SQL);
            ResultSet executeResult = statement.executeQuery(SQL);

            while (executeResult.next()) {
                System.out.println(executeResult.getInt("id") + " " + executeResult.getString("data"));

            }
        }
    }
}
