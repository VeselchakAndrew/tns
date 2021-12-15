package ua.tns.employeeproductivity.dao.employee;

import ua.tns.employeeproductivity.models.Employee;
import ua.tns.employeeproductivity.utils.ConnectionManager;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO {
//    List<Employee> employees = List.of(
//            Employee.builder().firstName("FirstName1").lastName("LastName1").company("firstCompany").department("FirstDepartment").build(),
//            Employee.builder().firstName("FirstName2").lastName("LastName2").company("firstCompany").department("FirstDepartment").build(),
//            Employee.builder().firstName("FirstName3").lastName("LastName3").company("firstCompany").department("SecondDepartment").build(),
//            Employee.builder().firstName("FirstName4").lastName("LastName4").company("firstCompany").department("SecondDepartment").build(),
//            Employee.builder().firstName("FirstName5").lastName("LastName5").company("firstCompany").department("ThirdDepartment").build(),
//            Employee.builder().firstName("FirstName6").lastName("LastName6").company("firstCompany").department("ThirdDepartment").build()
//    );

    private static final String DELETE_SQL = """
            DELETE FROM employees
            WHERE employee_id = ?
            """;

    private static final String SAVE_SQL = """
            INSERT INTO employees (
            employee_firstname,
            employee_lastname,
            employee_role,
            employee_department_id,
            preferred_start_working,
            work_from_home
            )
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    private static final String UPDATE_SQL = """
            UPDATE employees
            SET employee_firstname = ?,
            employee_lastname = ?,
            employee_role = ?,
            employee_department_id = ?,
            preferred_start_working = ?,
            work_from_home = ?
            WHERE employee_id = ?
            """;

    private static final String FIND_BY_ID = """
            SELECT employee_id,
            employee_firstname,
            employee_lastname,
            employee_company,
            employee_role,
            employee_department_id,
            preferred_start_working,
            work_from_home
            FROM employees
            WHERE employee_id = ?
            """;

    private static final EmployeeDAO INSTANCE = new EmployeeDAO();

    private EmployeeDAO() {
    }

    public static EmployeeDAO getInstance() {
        return INSTANCE;
    }

    public Optional<Employee> findById(Long id) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee = null;
            if(resultSet.next()) {

            }
            return Optional.ofNullable(employee);

        } catch (SQLException throwable) {
            throw new SQLException(throwable);
        }
    }

    public Employee save(Employee employee) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setLong(3, employee.getEmployeeRole());
            preparedStatement.setLong(4, employee.getDepartment());
            preparedStatement.setInt(5, employee.getPreferences());
            preparedStatement.setBoolean(6, employee.getWorkFromHome());
            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                employee.setId(generatedKeys.getLong("employee_id"));
            }
            return employee;
        } catch (SQLException throwable) {
            throw new SQLException(throwable);
        }
    }

    public void update(Employee employee) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SQL);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setLong(3, employee.getEmployeeRole());
            preparedStatement.setLong(4, employee.getDepartment());
            preparedStatement.setInt(5, employee.getPreferences());
            preparedStatement.setBoolean(6, employee.getWorkFromHome());
            preparedStatement.setLong(7, employee.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException throwable) {
            throw new SQLException(throwable);
        }

    }

    public boolean delete(Long id) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SQL);
            preparedStatement.setLong(1, id);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwable) {
            throw new SQLException(throwable);
        }
    }

}
