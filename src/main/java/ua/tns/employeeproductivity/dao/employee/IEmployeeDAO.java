package ua.tns.employeeproductivity.dao.employee;

import ua.tns.employeeproductivity.entity.Employee;

import java.util.List;

interface IEmployeeDAO {
    List<Employee> getAllEmployees();

    Employee getEmployeeById(long id);

    Employee updateEmployee(Employee employee);

    boolean saveEmployeeToDB(Employee employee);

    boolean deleteEmployeeFromDB(long id);
}
