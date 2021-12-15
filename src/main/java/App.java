import ua.tns.employeeproductivity.dao.employee.EmployeeDAO;

import java.sql.SQLException;


public class App {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO instance = EmployeeDAO.getInstance();

        instance.delete(1L);
    }
}
