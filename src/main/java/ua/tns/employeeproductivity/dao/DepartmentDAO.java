package ua.tns.employeeproductivity.dao;

import ua.tns.employeeproductivity.entity.Department;
import ua.tns.employeeproductivity.entity.Employee;
import ua.tns.employeeproductivity.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DepartmentDAO implements DAO<Long, Department> {

    private static final DepartmentDAO INSTANCE = new DepartmentDAO();

    private DepartmentDAO() {
    }

    public static DepartmentDAO getInstance() {
        return INSTANCE;
    }

    private static final String FIND_ALL_SQL = """
            SELECT department_id,
            department_name,
            synchronize
            FROM departments
            """;

    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE  department_id = ?
            """;

    @Override
    public List<Department> findAll() throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Department> departments = new ArrayList<>();
            while (resultSet.next()) {
                departments.add(getDepartment(resultSet));
            }
            return departments;

        } catch (SQLException throwable) {
            throw new SQLException(throwable);

        }
    }


    @Override
    public Optional<Department> findById(Long id) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            Department department = null;
            if (resultSet.next()) {
                department = getDepartment(resultSet);

            }
            return Optional.ofNullable(department);

        } catch (SQLException throwable) {
            throw new SQLException(throwable);
        }
    }

    @Override
    public Department save(Department entity) throws SQLException {
        return null;
    }

    @Override
    public void update(Department entity) throws SQLException {

    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    private Department getDepartment(ResultSet resultSet) throws SQLException {
        return new Department(
                resultSet.getLong("department_id"),
                resultSet.getString("department_name"),
                resultSet.getBoolean("synchronize")
        );
    }
}
