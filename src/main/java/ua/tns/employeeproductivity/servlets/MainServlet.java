package ua.tns.employeeproductivity.servlets;

import ua.tns.employeeproductivity.bean.ProductivityBean;
import ua.tns.employeeproductivity.dao.DepartmentDAO;
import ua.tns.employeeproductivity.dao.EmployeeDAO;
import ua.tns.employeeproductivity.entity.Department;
import ua.tns.employeeproductivity.entity.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@WebServlet("/")
public class MainServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeDAO employeeDAO = EmployeeDAO.getInstance();
        DepartmentDAO departmentDAO = DepartmentDAO.getInstance();
        ProductivityBean productivityBean = new ProductivityBean();
        List<Employee> employees = new ArrayList<>();
        List<String> departments = new ArrayList<>();

        try {
            employees = employeeDAO.findAll();
        } catch (SQLException e) {
            e.printStackTrace();

        }

        Optional<Double> totalProductivity = employees.stream()
                .map(e -> productivityBean.employeeProductivity(e.getPreferences()))
                .reduce(Double::sum);

        String companyName = "My company";

        try {
            departments = departmentDAO.findAll().stream().
                    map(Department::getName)
                    .collect(Collectors.toList());


            req.setAttribute("companyName", companyName);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("departments", departments);
        req.setAttribute("totalProductivity", totalProductivity.orElse(0d));
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/Main.jsp");
        requestDispatcher.forward(req, resp);
    }


}
