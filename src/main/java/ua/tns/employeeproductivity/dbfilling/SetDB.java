package ua.tns.employeeproductivity.dbfilling;

import ua.tns.employeeproductivity.dao.employee.EmployeeDAO;
import ua.tns.employeeproductivity.models.Employee;

import java.sql.SQLException;

public class SetDB {
    public static void main(String[] args) throws SQLException {
        EmployeeDAO instance = EmployeeDAO.getInstance();

        Employee e1 = new Employee();
        e1.setFirstName("FN3");
        e1.setLastName("LN3");
        e1.setEmployeeRole(1L);
        e1.setDepartment(1L);
        e1.setPreferences(0);
        e1.setWorkFromHome(true);

        Employee savedEmployee = instance.save(e1);
    }
}
