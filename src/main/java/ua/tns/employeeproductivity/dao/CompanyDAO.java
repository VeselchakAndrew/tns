package ua.tns.employeeproductivity.dao;

import ua.tns.employeeproductivity.entity.Company;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CompanyDAO implements DAO<Long, Company> {

    private static final CompanyDAO INSTANCE = new CompanyDAO();

    private CompanyDAO() {
    }

    public static CompanyDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public List<Company> findAll() throws SQLException {
        return null;
    }

    @Override
    public Optional<Company> findById(Long id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public Company save(Company entity) throws SQLException {
        return null;
    }

    @Override
    public void update(Company entity) throws SQLException {

    }

    @Override
    public boolean delete(Long id) throws SQLException {
        return false;
    }
}
