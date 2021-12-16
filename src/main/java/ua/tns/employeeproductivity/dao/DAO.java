package ua.tns.employeeproductivity.dao;

import ua.tns.employeeproductivity.entity.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO<K, E> {
    List<E> findAll() throws SQLException;

    Optional<E> findById(K id) throws SQLException;

    E save(E entity) throws SQLException;

    void update(E entity) throws SQLException;

    boolean delete(K id) throws SQLException;
}
