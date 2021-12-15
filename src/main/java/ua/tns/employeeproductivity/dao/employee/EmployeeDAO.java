package ua.tns.employeeproductivity.dao.employee;

import ua.tns.employeeproductivity.entity.Employee;

import java.util.List;

public class EmployeeDAO implements IEmployeeDAO {
    List<Employee> employees = List.of(
            Employee.builder().firstName("FirstName1").lastName("LastName1").company("firstCompany").department("FirstDepartment").build(),
            Employee.builder().firstName("FirstName2").lastName("LastName2").company("firstCompany").department("FirstDepartment").build(),
            Employee.builder().firstName("FirstName3").lastName("LastName3").company("firstCompany").department("SecondDepartment").build(),
            Employee.builder().firstName("FirstName4").lastName("LastName4").company("firstCompany").department("SecondDepartment").build(),
            Employee.builder().firstName("FirstName5").lastName("LastName5").company("firstCompany").department("ThirdDepartment").build(),
            Employee.builder().firstName("FirstName6").lastName("LastName6").company("firstCompany").department("ThirdDepartment").build()
    );


    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @Override
    public Employee getEmployeeById(long id) {
        return null;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return null;
    }

    @Override
    public boolean saveEmployeeToDB(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteEmployeeFromDB(long id) {
        return false;
    }
}
