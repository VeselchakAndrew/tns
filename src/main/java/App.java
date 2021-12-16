import ua.tns.employeeproductivity.bean.ProductivityBean;
import ua.tns.employeeproductivity.dao.EmployeeDAO;
import ua.tns.employeeproductivity.entity.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


public class App {
    public static void main(String[] args) throws SQLException {
//        EmployeeDAO instance = EmployeeDAO.getInstance();
//        Optional<Employee> employee = instance.findById(2L);
//        System.out.println(employee);

        List<Double> prod = List.of(
                new ProductivityBean().employeeProductivity(0),
                new ProductivityBean().employeeProductivity(-1),
                new ProductivityBean().employeeProductivity(1),
                new ProductivityBean().employeeProductivity(-2),
                new ProductivityBean().employeeProductivity(4),
                new ProductivityBean().employeeProductivity(2)
        );
        System.out.println(prod);


//        List<Employee> all = instance.findAll();
//        for (Employee value : all) {
//            System.out.println(value);
//        }
    }
}
