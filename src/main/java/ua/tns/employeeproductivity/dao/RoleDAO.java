package ua.tns.employeeproductivity.dao;

import ua.tns.employeeproductivity.entity.EmployeeRole;
import ua.tns.employeeproductivity.utils.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RoleDAO implements DAO<Long, EmployeeRole> {
    private static final String FIND_ALL_SQL = """
            SELECT role_id,
            role_name
            FROM employee_roles
            """;

    private static final String FIND_BY_ID_SQL = FIND_ALL_SQL + """
            WHERE  role_id = ?
            """;

    private static final RoleDAO INSTANCE = new RoleDAO();

    private RoleDAO() {

    }

    public static RoleDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public List<EmployeeRole> findAll() throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL_SQL);
            ResultSet resultSet = preparedStatement.executeQuery();

            List<EmployeeRole> employeeRoles = new ArrayList<>();

            while (resultSet.next()) {
                employeeRoles.add(getRole(resultSet));
            }
            return employeeRoles;
        }
    }

    @Override
    public Optional<EmployeeRole> findById(Long id) throws SQLException {
        try (Connection connection = ConnectionManager.open()) {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID_SQL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            EmployeeRole employeeRole = null;

            if (resultSet.next()) {
                employeeRole = getRole(resultSet);
            }
            return Optional.ofNullable(employeeRole);
        }

    }

    @Override
    public EmployeeRole save(EmployeeRole entity) throws SQLException {
        return null;
    }

    @Override
    public void update(EmployeeRole entity) throws SQLException {

    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }

    private EmployeeRole getRole(ResultSet resultSet) throws SQLException {
        return new EmployeeRole(
                resultSet.getLong("role_id"),
                resultSet.getString("role_name")
        );
    }
}
