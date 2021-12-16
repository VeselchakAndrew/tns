package ua.tns.employeeproductivity.dao;

import ua.tns.employeeproductivity.entity.Employee;
import ua.tns.employeeproductivity.utils.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDAO implements DAO<Long, Employee> {

    private final DepartmentDAO departmentDAO = DepartmentDAO.getInstance();
    private final RoleDAO roleDAO = RoleDAO.getInstance();

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


    private static final String FIND_ALL_SQL = """
            SELECT employee_id,
            employee_firstname,
            employee_lastname,
            employee_company,
            employee_role,
            employee_department_id,
            preferred_start_working,
            work_from_home
            FROM employees
            """;

    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE employee_id = ?
            """;

    private static final EmployeeDAO INSTANCE = new EmployeeDAO();

    private EmployeeDAO() {
    }

    public static EmployeeDAO getInstance() {
        return INSTANCE;
    }


    public List<Employee> findAll() throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                employees.add(getEmployee(resultSet));
            }
            return employees;


        } catch (SQLException throwable) {
            throw new SQLException(throwable);

        }
    }

    public Optional<Employee> findById(Long id) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Employee employee = null;
            if (resultSet.next()) {
                employee = getEmployee(resultSet);

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
            preparedStatement.setLong(3, employee.getEmployeeRole().getId());
            preparedStatement.setLong(4, employee.getDepartment().getId());
            preparedStatement.setInt(5, employee.getPreferences());
            preparedStatement.setBoolean(6, employee.isWorkFromHome());
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
            preparedStatement.setLong(3, employee.getEmployeeRole().getId());
            preparedStatement.setLong(4, employee.getDepartment().getId());
            preparedStatement.setInt(5, employee.getPreferences());
            preparedStatement.setBoolean(6, employee.isWorkFromHome());
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

    private Employee getEmployee(ResultSet resultSet) throws SQLException {
        return new Employee(
                resultSet.getLong("employee_id"),
                resultSet.getString("employee_firstname"),
                resultSet.getString("employee_lastname"),
                resultSet.getString("employee_company"),
                departmentDAO.findById(resultSet.getLong("employee_department_id")).orElse(null),
                roleDAO.findById(resultSet.getLong("employee_role")).orElse(null),
                resultSet.getInt("preferred_start_working"),
                resultSet.getBoolean("work_from_home")
        );
    }

}
