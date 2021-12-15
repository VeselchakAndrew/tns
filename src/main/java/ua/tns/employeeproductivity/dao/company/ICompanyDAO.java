package ua.tns.employeeproductivity.dao.company;

import ua.tns.employeeproductivity.models.Company;
import ua.tns.employeeproductivity.models.Employee;

interface ICompanyDAO {
    Company getCompanyByID(Long id);

    Company getCompanyByName(String name);

    Company updateCompany(Company company);

    boolean saveCompanyToDB(Company company);

    boolean deleteCompanyFromDB(long id);

}
