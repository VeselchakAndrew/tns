package ua.tns.employeeproductivity.dbfilling;

import ua.tns.employeeproductivity.dao.EmployeeDAO;
import ua.tns.employeeproductivity.entity.Department;
import ua.tns.employeeproductivity.entity.Employee;
import ua.tns.employeeproductivity.entity.EmployeeRole;

import java.sql.SQLException;
import java.util.Random;

public class SetDB {
    private static final Random random = new Random();

    public static void main(String[] args) throws SQLException {
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();

        for (int i = 0; i <= 50; i++) {

            int fnIdx = random.nextInt(198);
            int lnIdx = random.nextInt(100);
            int preference = random.nextInt(-2, 5);
            boolean workFromHome = random.nextBoolean();
            long emplRole = random.nextLong(1,5);
            long emplDepartment = random.nextLong(1, 6);


            Employee e1 = new Employee();
            e1.setFirstName(String.valueOf(EmployeeFirstName.values()[fnIdx]));
            e1.setLastName(String.valueOf(EmployeeFirstName.values()[lnIdx]));
            e1.setEmployeeRole(new EmployeeRole(emplRole));
            e1.setDepartment(new Department(emplDepartment));
            e1.setPreferences(preference);
            e1.setWorkFromHome(workFromHome);
            Employee savedEmployee = employeeDAO.save(e1);
            System.out.println(i);

        }

    }
}
