package ua.tns.employeeproductivity.dao.department;

import ua.tns.employeeproductivity.models.Department;

interface IDepartmentDAO {
    Department getDepartmentByID(Long id);

    Department getCompanyByName(String name);

    Department updateCompany(Department department);

    boolean saveDepartmentToDB(Department department);

    boolean deleteDepartmentFromDB(long id);
}
